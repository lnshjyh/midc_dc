package org.cw.midc.service;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.cw.midc.ParamFilter;
import org.cw.midc.dao.MediaInfoDao;
import org.cw.midc.dao.StorageInfoDao;
//import org.cw.midc.model.FileInfo;
import org.cw.midc.entity.MediaInfo;
import org.cw.midc.entity.StorageInfo;
import org.cw.midc.entity.User;
//import org.cw.midc.repository.storage.MediaRepository;
//import org.cw.midc.repository.storage.StorageRepository;
import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.UserContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;

@Service
public class StorageService 
{
	private static final Logger log = LoggerFactory.getLogger(StorageService.class);
	
	
	@Autowired
	private StorageInfoDao storageInfoDao;
	
	
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
	
	public List getList(ParamFilter param) {
        return storageInfoDao.findMap("getList", param.getParam(), param.getPage());
    }

    @Transactional
    public void updateUnUseful() {
        storageInfoDao.update("updateUnUseful", null);
    }

    @Transactional
    public void add(StorageInfo storageInfo) {
    	checkNotNull(storageInfo, "不能为空");
    	checkArgument(!Strings.isNullOrEmpty(storageInfo.getPath()), "路径不能为空");
    	checkArgument(!Strings.isNullOrEmpty(storageInfo.getName()), "名称不能为空");
    	String path = storageInfo.getPath();
    	File pobj = new File(path);
    	checkArgument(pobj.isDirectory() && pobj.exists(), "路径不存在");
    	storageInfo.setCreateTime(new Date());
    	storageInfo.setUpdateTime(new Date());
    	storageInfo.setStatus("1");
    	storageInfo.setStorageId(CommonUtils.generateNumFive());
    	User user = (User)UserContextUtil.getAttribute("currentUser");
    	storageInfo.setCreateBy(user.getUserId());
    	storageInfoDao.update("updateUnUseful", null);

    	storageInfoDao.save(storageInfo);
    }


    public void delete(List<String> ids) {
    	checkArgument((ids != null && ids.size() > 0), "编号不能为空");
        for (String id : ids) {
        	storageInfoDao.delete("deleteById", id);
        }
    }

	
	public MediaInfo getMediaInfo(String mediaId)
	{
//		MediaInfo mi = mediaRepository.findOne(mediaId);
		MediaInfo mediaInfo = mediaInfoDao.findUnique("selectByPrimaryKey", mediaId);
		return mediaInfo;
	}
}
