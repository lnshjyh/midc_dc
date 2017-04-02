package org.cw.midc.service;

import java.util.List;

import org.cw.midc.model.FileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BatchLoadDicomFileScheduledService {

	private static final Logger log = LoggerFactory.getLogger(BatchLoadDicomFileScheduledService.class);
	
	@Autowired
	private LoadDicomFileService loadDicomFileService;
	
	@Autowired
	private DicomFileService dicomFileService;
	
//	@Scheduled(fixedDelay = 1000)
	public void parseBatch()
	{
		log.debug("Load dicom file task execute.");
        //获取一批未解析文件信息
		List<FileInfo> unHandledFileInfoList = dicomFileService.getUnHandledFileInfoByBatch(100);
		
		//按个解析存入数据库
//		unHandledFileInfoList.forEach(loadDicomFileService::loadDicomFile);
	}
	
	
}
