package org.cw.midc.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.cw.midc.model.FileInfo;
import org.cw.midc.model.storage.MediaInfo;
import org.cw.midc.repository.FileInfoRepository;
import org.cw.midc.repository.storage.MediaRepository;
import org.cw.midc.util.CommonUtils;
import org.rribbit.Listener;
import org.rribbit.RequestResponseBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Scope("prototype")
public class DicomFileService {

	private static final Logger log = LoggerFactory.getLogger(DicomFileService.class);
	
	@Autowired
	private StorageService storageService;
	
	@Autowired
	private FileInfoRepository fileInfoRepository;
	
	@Autowired
	private MediaRepository mediaRepository;
	
	@Autowired
	private RequestResponseBus eventBus;
	
	/**
	 * 存储文件到文件系统，并且存文件信息
	 * @param file
	 * @param userId
	 * @param studyInfoId
	 */
	public void saveFileAndGenerateParserTask(MultipartFile file, String userId, String studyInfoId)
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
		FileInfo fileInfo = new FileInfo(fileId, fileRelativePath, file.getOriginalFilename(), studyInfoId, mediaInfo.getId(), userId);		
		fileInfoRepository.save(fileInfo);
		eventBus.send("dicomFileUploaded", fileInfo);
	}
	
	public File getFile(String fileId)
	{
		String storageBasePath = storageService.getCurrentBaseStoragePath();
		FileInfo fileInfo = fileInfoRepository.findOne(fileId);
		MediaInfo mediaInfo = mediaRepository.findOne(fileInfo.getMediaId());
		String fileAbsolutePathStr = storageBasePath + mediaInfo.getPath() + fileInfo.getFilePath();
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
		PageRequest pageRequest = new PageRequest(0, batchCount, new Sort(Sort.Direction.ASC, "createTime"));
		List<FileInfo> result = fileInfoRepository.findByStatus("0", pageRequest);
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
		fileInfoRepository.updateStatusByID("1", fileInfo.getId(), "");
	}
	
	/**
	 * 监听解析失败事件
	 * @param fileInfo
	 */
	@Transactional
	@Listener(hint = "parseFileFailed")
	public void onParseFileFailed(FileInfo fileInfo)
	{
		fileInfoRepository.updateStatusByID("2", fileInfo.getId(), fileInfo.getFailedReason());
	}
	
}
