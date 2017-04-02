package org.cw.midc.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.cw.midc.exception.RisInfoNotFoundException;
import org.cw.midc.model.FileInfo;
import org.cw.midc.model.pacs.Instance;
import org.cw.midc.model.pacs.Series;
import org.cw.midc.model.pacs.Study;
import org.cw.midc.model.ris.StudyInfo;
import org.cw.midc.repository.pacs.InstanceRepository;
import org.cw.midc.repository.pacs.SeriesRepository;
import org.cw.midc.repository.pacs.StudyRepository;
import org.cw.midc.repository.ris.StudyInfoRepository;
import org.cw.midc.service.factory.PacsFactory;
import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.FileService;
import org.dcm4che2.data.BasicDicomObject;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.io.DicomInputStream;
import org.rribbit.Listener;
import org.rribbit.RequestResponseBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.lingala.zip4j.exception.ZipException;

@Service
public class LoadDicomFileService {
	
	
	private static final Logger log = LoggerFactory.getLogger(LoadDicomFileService.class);
	
	@Autowired
	private PacsFactory pacsFactory;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private StorageService storageService;
	
	@Autowired
	private StudyRepository studyRepository;
	
	@Autowired
	private SeriesRepository seriesRepository;
	
	@Autowired
	private InstanceRepository instanceRepository;
	
	@Autowired
	private StudyInfoRepository studyInfoRepository;
	
	@Autowired
	private RequestResponseBus eventBus;
	
	@Listener(hint = "dicomFileUploaded")
	public void loadDicomFile(FileInfo fileInfo)
	{
		try
		{
			loadDicomFile2DB(fileInfo);
			eventBus.send("parseFileSucceeded", fileInfo);
		}
		catch(Exception e)
		{
			fileInfo.setFailedReason(StringUtils.substring(e.getMessage(), 0, 255));
			eventBus.send("parseFileFailed", fileInfo);
			log.error("File:{} parse failed, cause: {}", fileInfo.getId(), e.getMessage());
		}
	}

	/**
	 * 解析单个Dicom文件到DB
	 * @param fileInfo
	 * @throws ZipException
	 * @throws IOException
	 * @throws RisInfoNotFoundException 
	 */
	public void loadDicomFile2DB(FileInfo fileInfo) throws ZipException, IOException, RisInfoNotFoundException
	{
		String newCloudStudyInfoId = fileInfo.getHospitalId() + fileInfo.getStudyInfoId();
		StudyInfo studyInfo = studyInfoRepository.findOne(newCloudStudyInfoId);
		if(studyInfo == null)
		{
			log.error("Ris Information not found for {}", newCloudStudyInfoId);
			throw new RisInfoNotFoundException(newCloudStudyInfoId);
		}
		
		String basePath = storageService.getCurrentBaseStoragePath();
		String mediaPath = storageService.getMediaPath(fileInfo.getMediaId());
		String src = basePath + mediaPath + fileInfo.getFilePath();
		File tempFile = null;
		try {
			tempFile = fileService.unzipOneFile(src);
		} catch (ZipException e1) {
			e1.printStackTrace();
			log.error("File:{} unzip failed!, cause: {}", fileInfo.getId(), e1.getMessage());;
			throw e1;
		}
		DicomObject dicom = new BasicDicomObject();
		DicomInputStream dis = null;
		try {
			dis = new DicomInputStream(tempFile);
			dicom = dis.readDicomObject();
			log.debug("Parse dicom file successfully.");
			
			//加载Dicom对象信息到DB
			loadDicomObj2DB(fileInfo, dicom, studyInfo);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("File:{} dicom file parse failed, cause: {}",fileInfo.getId(), e.getMessage());
			throw e;
		} finally {
			if(dis != null)
			{
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
					log.error("File:{} close dicom stream failed, cause: {}",fileInfo.getId(), e.getMessage());
					throw e;
				}				
			}
			tempFile.delete();
		}		
	}
	
	/**
	 * 将Dicom对象加载到study, series, instance三级表中
	 * @param fileInfo
	 * @param dicom
	 */
	public void loadDicomObj2DB(FileInfo fileInfo, DicomObject dicom, StudyInfo studyInfo)
	{
		String studyInstanceUId = dicom.getString(Tag.StudyInstanceUID);
		String seriesInstanceUId = dicom.getString(Tag.SeriesInstanceUID);
		String sopInstanceUId = dicom.getString(Tag.SOPInstanceUID);
		String studyUID = CommonUtils.MD5(fileInfo.getHospitalId() + studyInstanceUId);
		String seriesUID = CommonUtils.MD5(fileInfo.getHospitalId() + seriesInstanceUId);
		String instanceUID = CommonUtils.MD5(fileInfo.getHospitalId() + sopInstanceUId);
		Study study = studyRepository.findOne(studyUID);
		Series series = null;
		Instance instance = null;
		if(study == null)//如果study不存在
		{
			//创建study
			study = pacsFactory.createStudyFrom(dicom, fileInfo, studyUID);
			studyInfo.getStudies().add(study);
			studyInfoRepository.save(studyInfo);
//			studyRepository.save(study);
			
			//创建series
			series = pacsFactory.createSeriesFrom(dicom, fileInfo, seriesUID, studyUID);
			seriesRepository.save(series);
			
			//创建instance
			instance = pacsFactory.createInstanceFrom(dicom, fileInfo, instanceUID, seriesUID);
			instanceRepository.save(instance);
		}
		else
		{
			series = seriesRepository.findOne(seriesUID);
			if(series == null)//序列不存在
			{
				//创建序列
				series = pacsFactory.createSeriesFrom(dicom, fileInfo, seriesUID, studyUID);
				seriesRepository.save(series);
				
				//创建instance
				instance = pacsFactory.createInstanceFrom(dicom, fileInfo, instanceUID, seriesUID);
				instanceRepository.save(instance);
			}
			else
			{
				instance = instanceRepository.findOne(instanceUID);
				if(instance == null)
				{
					//仅创建instance
					instance = pacsFactory.createInstanceFrom(dicom, fileInfo, instanceUID, seriesUID);
					instanceRepository.save(instance);
				}
				else
				{
					log.info("File:{} exist, ignore it", fileInfo.getId());
				}
			}
		}
	}
	
}
