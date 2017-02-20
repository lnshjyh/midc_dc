package org.cw.midc.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.cw.midc.model.FileInfo;
import org.cw.midc.model.storage.MediaInfo;
import org.cw.midc.model.storage.StorageInfo;
import org.cw.midc.repository.storage.MediaRepository;
import org.cw.midc.repository.storage.StorageRepository;
import org.cw.midc.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageService 
{
	private static final Logger log = LoggerFactory.getLogger(StorageService.class);
	
	@Autowired
	private StorageRepository storageRepository;
	
	@Autowired
	private MediaRepository mediaRepository;
	
	public String getCurrentBaseStoragePath()
	{
		StorageInfo storageInfo = storageRepository.findByStatus("1");
		if(storageInfo == null)
		{
			log.error("No storageInfo effective!");
		}
		return storageInfo.getPath();
	}
	
	public MediaInfo getCurrentMedia()
	{
		String mediaName = new SimpleDateFormat("YYYYMMDD").format(new Date());
		MediaInfo mediaInfo = mediaRepository.findByName(mediaName);
		if(mediaInfo == null)
		{
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
			MediaInfo mediaInfoNew = new MediaInfo(mediaId, mediaName, mediaRelativePath);
			mediaRepository.save(mediaInfoNew);
			
			//返回mediainfo
			return mediaInfoNew;
		}
		
		return mediaInfo;
	}
	
	public String getMediaPath(String mediaId)
	{
		MediaInfo mi = mediaRepository.findOne(mediaId);
		return mi.getPath();
	}
}
