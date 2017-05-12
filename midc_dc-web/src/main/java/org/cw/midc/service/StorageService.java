package org.cw.midc.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.cw.midc.dao.MediaInfoDao;
import org.cw.midc.dao.StorageInfoDao;
//import org.cw.midc.model.FileInfo;
import org.cw.midc.entity.MediaInfo;
import org.cw.midc.entity.StorageInfo;
//import org.cw.midc.repository.storage.MediaRepository;
//import org.cw.midc.repository.storage.StorageRepository;
import org.cw.midc.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageService 
{
	private static final Logger log = LoggerFactory.getLogger(StorageService.class);
	
//	@Autowired
//	private StorageRepository storageRepository;
	
	@Autowired
	private StorageInfoDao storageInfoDao;
	
//	@Autowired
//	private MediaRepository mediaRepository;
	
	@Autowired
	private MediaInfoDao mediaInfoDao;
	
	public String getCurrentBaseStoragePath()
	{
//		StorageInfo storageInfo = storageRepository.findByStatus("1");
		StorageInfo storageInfo = storageInfoDao.findUnique("selectByStatus", "1");
		if(storageInfo == null)
		{
			log.error("No storageInfo effective!");
		}
		return storageInfo.getPath();
	}
	
	public StorageInfo getStorageInfoById(String storageId)
	{
//		StorageInfo storageInfo = storageRepository.findByStatus("1");
		StorageInfo storageInfo = storageInfoDao.findUnique("selectByPrimaryKey", storageId);
		if(storageInfo == null)
		{
			log.error("No storageInfo effective!");
		}
		return storageInfo;
	}
	
	public MediaInfo getCurrentMedia()
	{
		String mediaName = new SimpleDateFormat("YYYYMMDD").format(new Date());
//		MediaInfo mediaInfo = mediaRepository.findByName(mediaName);
		MediaInfo mediaInfo = mediaInfoDao.findUnique("selectByName", mediaName);
		if(mediaInfo == null)
		{
			StorageInfo storageInfo = storageInfoDao.findUnique("selectByStatus", "1");
			if(storageInfo == null)
			{
				log.error("No storageInfo effective!");
			}
			String mediaRelativePath = "/" + mediaName;
			//创建目录
			File mediaDir = new File(getCurrentBaseStoragePath() + mediaRelativePath);
			if(!mediaDir.exists() && !mediaDir .isDirectory())
			{
				log.info("create new media path: {}", mediaDir);
				mediaDir.mkdir();
			}
			
			//创建数据
			String mediaId = CommonUtils.generateId();
			MediaInfo mediaInfoNew = new MediaInfo(mediaId, storageInfo.getStorageId(), mediaName, mediaRelativePath);
			mediaInfoDao.save(mediaInfoNew);
			
			//返回mediainfo
			return mediaInfoNew;
		}
		
		return mediaInfo;
	}
	
	public String getMediaPath(String mediaId)
	{
//		MediaInfo mi = mediaRepository.findOne(mediaId);
		MediaInfo mi = mediaInfoDao.findUnique("selectByPrimaryKey", mediaId);
		return mi.getPath();
	}
	
	public MediaInfo getMediaInfo(String mediaId)
	{
//		MediaInfo mi = mediaRepository.findOne(mediaId);
		MediaInfo mediaInfo = mediaInfoDao.findUnique("selectByPrimaryKey", mediaId);
		return mediaInfo;
	}
}
