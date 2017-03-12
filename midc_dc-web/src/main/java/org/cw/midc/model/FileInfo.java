package org.cw.midc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.cw.midc.BaseEntity;

public class FileInfo extends BaseEntity  {

	private String id;
	
	private String filePath;
	
	private String origFileName;
	
	private String studyInfoId;
	
	private String userId;
	
	private String mediaId;
	
	/**
	 * 0:initial, 1:parse success，2:parse failed
	 */
	private String status;
	
	private String failedReason;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private Date createTime;
	
	private Date updateTime;
	
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	
	public FileInfo()
	{
		
	}
	
	public FileInfo(String id, String filePath, String origFileName, String studyInfoId, String mediaId, String userId)
	{
		this.id = id;
		this.filePath = filePath;
		this.origFileName = origFileName;
		this.studyInfoId = studyInfoId;
		this.mediaId = mediaId;
		this.userId = userId;
		this.status = "0";
		this.createTime = new Date();
		this.updateTime = this.createTime;		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getOrigFileName() {
		return origFileName;
	}

	public void setOrigFileName(String origFileName) {
		this.origFileName = origFileName;
	}

	public String getStudyInfoId() {
		return studyInfoId;
	}

	public void setStudyInfoId(String studyInfoId) {
		this.studyInfoId = studyInfoId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getFailedReason() {
		return failedReason;
	}

	public void setFailedReason(String failedReason) {
		this.failedReason = failedReason;
	}
	
	
	
}
