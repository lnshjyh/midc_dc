package org.cw.midc.entity;

import java.util.Date;

import org.cw.midc.BaseEntity;

public class MediaInfo extends BaseEntity{
    private String mediaId;
    
    private String storageId;

    private Date createTime;

    private String mediaName;

    private String path;

    private String status;

    private Date updateTime;
    
	public MediaInfo()
	{
		
	}
	
	public MediaInfo(String mediaId, String storageId, String mediaName, String path)
	{
		this.mediaId = mediaId;
		this.storageId = storageId;
		this.mediaName = mediaName;
		this.path = path;
		this.status = "1";
		this.createTime = new Date();
		this.updateTime = this.createTime;
	}

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId == null ? null : mediaId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName == null ? null : mediaName.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
    
    
}