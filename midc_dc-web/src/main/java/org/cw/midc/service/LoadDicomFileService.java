package org.cw.midc.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.cw.midc.dao.InstanceDao;
import org.cw.midc.dao.RisPacsRelDao;
import org.cw.midc.dao.SeriesDao;
import org.cw.midc.dao.StudyDao;
import org.cw.midc.dao.StudyInfoDao;
import org.cw.midc.entity.FileInfo;
import org.cw.midc.entity.Instance;
import org.cw.midc.entity.MediaInfo;
import org.cw.midc.entity.RisPacsRel;
import org.cw.midc.entity.Series;
import org.cw.midc.entity.StorageInfo;
import org.cw.midc.entity.Study;
import org.cw.midc.entity.StudyInfo;
import org.cw.midc.exception.DicomFileDuplicatedException;
import org.cw.midc.exception.RisInfoNotFoundException;
//import org.cw.midc.repository.ris.StudyInfoRepository;
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
import org.springframework.transaction.annotation.Transactional;

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
	private StudyDao studyDao;
	
	@Autowired
	private SeriesDao seriesDao;
	
	@Autowired
	private InstanceDao instanceDao;
	
	@Autowired
	private RisPacsRelDao risPacsRelDao;
	
	@Autowired
	private StudyInfoDao studyInfoDao;
	
	@Autowired
	private RequestResponseBus eventBus;
	
	@Listener(hint = "dicomFileUploaded")
	public void loadDicomFile(FileInfo fileInfo) throws Exception
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
			log.error("File:{} parse failed, cause: {}", fileInfo.getFileId(), e.getMessage());
		}
	}

	/**
	 * 解析单个Dicom文件到DB
	 * @param fileInfo
	 * @throws ZipException
	 * @throws IOException
	 * @throws RisInfoNotFoundException 
	 * @throws DicomFileDuplicatedException 
	 */
	public void loadDicomFile2DB(FileInfo fileInfo) throws ZipException, IOException, RisInfoNotFoundException, DicomFileDuplicatedException
	{
		String newCloudStudyInfoId = fileInfo.getHospitalId() + fileInfo.getStudyInfoId();
		StudyInfo studyInfo = studyInfoDao.findUnique("getById", newCloudStudyInfoId);
		if(studyInfo == null)
		{
			log.error("Ris Information not found for {}", newCloudStudyInfoId);
			throw new RisInfoNotFoundException(newCloudStudyInfoId);
		}
		
		MediaInfo mediaInfo = storageService.getMediaInfo(fileInfo.getMediaId());
		StorageInfo storageInfo = storageService.getStorageInfoById(mediaInfo.getStorageId());
		String src = storageInfo.getPath() + mediaInfo.getPath() + fileInfo.getFilePath();
		File tempFile = null;
		try {
			tempFile = fileService.unzipOneFile(src);
		} catch (ZipException e1) {
			e1.printStackTrace();
			log.error("File:{} unzip failed!, cause: {}", fileInfo.getFileId(), e1.getMessage());;
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
			log.error("File:{} dicom file parse failed, cause: {}",fileInfo.getFileId(), e.getMessage());
			throw e;
		} catch (DicomFileDuplicatedException de) {
			throw de;
		}
		finally {
			if(dis != null)
			{
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
					log.error("File:{} close dicom stream failed, cause: {}",fileInfo.getFileId(), e.getMessage());
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
	 * @throws DicomFileDuplicatedException 
	 */
	@Transactional(rollbackFor=Exception.class)
	public void loadDicomObj2DB(FileInfo fileInfo, DicomObject dicom, StudyInfo studyInfo) throws DicomFileDuplicatedException
	{
		String studyInstanceUId = dicom.getString(Tag.StudyInstanceUID);
		String seriesInstanceUId = dicom.getString(Tag.SeriesInstanceUID);
		String sopInstanceUId = dicom.getString(Tag.SOPInstanceUID);
		String studyUID = CommonUtils.MD5(fileInfo.getHospitalId() + studyInstanceUId);
		String seriesUID = CommonUtils.MD5(fileInfo.getHospitalId() + seriesInstanceUId);
		String instanceUID = CommonUtils.MD5(fileInfo.getHospitalId() + sopInstanceUId);
		Study study = studyDao.findUnique("selectByPrimaryKey", studyUID);
		Series series = null;
		Instance instance = null;
		if(study == null)//如果study不存在
		{
			//创建study
			study = pacsFactory.createStudyFrom(dicom, fileInfo, studyUID);
			
			//存储Study
			studyDao.save(study);

			//存储Ris和pacs关联关系表
			RisPacsRel rel = new RisPacsRel(studyInfo.getStudyinfoId(), studyUID);
			risPacsRelDao.save(rel);
			

			
			//创建series
			series = pacsFactory.createSeriesFrom(dicom, fileInfo, seriesUID, studyUID);
			seriesDao.save(series);
			
			//创建instance
			instance = pacsFactory.createInstanceFrom(dicom, fileInfo, instanceUID, seriesUID);
			instanceDao.save(instance);
			
			//图象数+1
			studyDao.update("increaseInstanceCount", studyUID);
		}
		else
		{
			series = seriesDao.findUnique("selectByPrimaryKey", seriesUID);
			if(series == null)//序列不存在
			{
				//创建序列
				series = pacsFactory.createSeriesFrom(dicom, fileInfo, seriesUID, studyUID);
				seriesDao.save(series);
				
				//创建instance
				instance = pacsFactory.createInstanceFrom(dicom, fileInfo, instanceUID, seriesUID);
				instanceDao.save(instance);
				
				//图象数+1
				studyDao.update("increaseInstanceCount", studyUID);
			}
			else
			{
				instance = instanceDao.findUnique("selectByPrimaryKey", seriesUID);
				if(instance == null)
				{
					//仅创建instance
					instance = pacsFactory.createInstanceFrom(dicom, fileInfo, instanceUID, seriesUID);
					instanceDao.save(instance);
					
					//图象数+1
					studyDao.update("increaseInstanceCount", studyUID);
				}
				else
				{
					log.error("File:{} exist, ignore it", fileInfo.getFileId());
					throw new DicomFileDuplicatedException();
				}
			}
		}
	}
	
}
