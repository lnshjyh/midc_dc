package org.cw.midc.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.cw.midc.dao.FileInfoDao;
import org.cw.midc.dao.HospitalDao;
import org.cw.midc.dao.MediaInfoDao;
import org.cw.midc.entity.FileInfo;
import org.cw.midc.entity.MediaInfo;
import org.cw.midc.entity.StorageInfo;
import org.cw.midc.entity.Hospital;
import org.cw.midc.util.CommonUtils;
import org.rribbit.Listener;
import org.rribbit.RequestResponseBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Maps;

@Service
@Scope("prototype")
public class DicomFileService {

	private static final Logger log = LoggerFactory.getLogger(DicomFileService.class);
	
	@Autowired
	private StorageService storageService;
	
	@Autowired
	private FileInfoDao fileInfoDao;
	
	
	@Autowired
	private MediaInfoDao mediaInfoDao;
	
	@Autowired
	private RequestResponseBus eventBus;
	
	@Autowired
	private HospitalDao hospitalDao;
	
	
	
	/**
	 * 存储文件到文件系统，并且存文件信息
	 * @param file
	 * @param userId
	 * @param studyInfoId
	 */
	public void saveFileAndGenerateParserTask(MultipartFile file, String clientId, String studyInfoId)
	{

		//获取根存储路径
		String storageBasePath = storageService.getCurrentBaseStoragePath();
		
		//获取meida信息
		MediaInfo mediaInfo = storageService.getCurrentMedia();
		
		//计算路径，规则为: storageBasePath/mediapath/studyInfoId/filename
		String fileBasePath = storageBasePath + mediaInfo.getPath();		
		String newFileName = CommonUtils.generateNewFileName();
		String fileRelativePath = "/" + studyInfoId + "/" + newFileName;
		String fileAbsolutePath = fileBasePath + fileRelativePath;
		File fileParentAbsolutDir = new File(fileBasePath + "/" + studyInfoId);
		
		//如果不存在则创建文件父路径
		if(!fileParentAbsolutDir.exists() && !fileParentAbsolutDir.isDirectory())
		{
			fileParentAbsolutDir.mkdir();
		}
		
		//保存文件
		File dicomFile = new File(fileAbsolutePath);		
		try 
		{
			file.transferTo(dicomFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}		
		
		//存储文件信息
		String fileId = CommonUtils.generateId();
		List<Hospital> hospitalList = hospitalDao.find("getByClientId", clientId);
		if(hospitalList == null || hospitalList.size() == 0)
		{
			return;
		}
		String hospitalId = hospitalList.get(0).getHospId();
		FileInfo fileInfo = new FileInfo(fileId, fileRelativePath, file.getOriginalFilename(), studyInfoId, mediaInfo.getMediaId(), hospitalId);		
		fileInfoDao.save(fileInfo);
		eventBus.send("dicomFileUploaded", fileInfo);
	}
	
	public File getFile(String fileId)
	{
//		String storageBasePath = storageService.getCurrentBaseStoragePath();
		FileInfo fileInfo = fileInfoDao.findUnique("selectByPrimaryKey", fileId);
//		MediaInfo mediaInfo = mediaInfoDao.findUnique("selectByPrimaryKey", fileInfo.getMediaId());
		MediaInfo mediaInfo = storageService.getMediaInfo(fileInfo.getMediaId());
		StorageInfo storageInfo = storageService.getStorageInfoById(mediaInfo.getStorageId());
		String fileAbsolutePathStr = storageInfo.getPath() + mediaInfo.getPath() + fileInfo.getFilePath();
		File file = new File(fileAbsolutePathStr);
		return file;
	}
	
	/**
	 * 按照批次数目，获取未处理的FileInfo记录
	 * @param batchNo
	 * @return
	 */
	public List<FileInfo> getUnHandledFileInfoByBatch(int batchCount)
	{
		List<FileInfo> result = fileInfoDao.find("selectByStatus", "0");
		return result;
	}
	
	/**
	 * 监听解析成功事件
	 * @param fileInfo
	 */
	@Transactional
	@Listener(hint = "parseFileSucceeded")
	public void onParseFileSucceeded(FileInfo fileInfo)
	{
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("status", "1");
        paramMap.put("failedReason", "");
        paramMap.put("fileId", fileInfo.getFileId());
        fileInfoDao.update("updateStatusById", paramMap);
	}
	
	/**
	 * 监听解析失败事件
	 * @param fileInfo
	 */
	@Transactional
	@Listener(hint = "parseFileFailed")
	public void onParseFileFailed(FileInfo fileInfo)
	{
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("status", "2");
        paramMap.put("failedReason", fileInfo.getFailedReason());
        paramMap.put("fileId", fileInfo.getFileId());
        fileInfoDao.update("updateStatusById", paramMap);
	}
	
}
