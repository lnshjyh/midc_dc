package org.cw.midc.entity;

import java.util.Date;

import org.cw.midc.BaseEntity;

public class FileInfo extends BaseEntity{
	
    private String fileId;

    private Date createTime;

    private String failedReason;

    private String filePath;

    private String hospitalId;

    private String mediaId;

    private String origFileName;

    private String status;

    private String studyInfoId;

    private Date updateTime;

    private String userId;
    
	public FileInfo()
	{
		this.status = "0";
		this.createTime = new Date();
		this.updateTime = this.createTime;	
	}
	
	public FileInfo(String id, String filePath, String origFileName, String studyInfoId, String mediaId, String hospitalId)
	{
		this.fileId = id;
		this.filePath = filePath;
		this.origFileName = origFileName;
		this.studyInfoId = studyInfoId;
		this.mediaId = mediaId;
		this.hospitalId = hospitalId;
		this.status = "0";
		this.createTime = new Date();
		this.updateTime = this.createTime;		
	}

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason == null ? null : failedReason.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId == null ? null : hospitalId.trim();
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId == null ? null : mediaId.trim();
    }

    public String getOrigFileName() {
        return origFileName;
    }

    public void setOrigFileName(String origFileName) {
        this.origFileName = origFileName == null ? null : origFileName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStudyInfoId() {
        return studyInfoId;
    }

    public void setStudyInfoId(String studyInfoId) {
        this.studyInfoId = studyInfoId == null ? null : studyInfoId.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}