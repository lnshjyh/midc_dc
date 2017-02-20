package org.cw.midc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="file_info")
public class FileInfo {

	@Id
	@Column(name = "file_id", length = 128)
	private String id;
	
	@Column(name = "file_path", length = 128)
	private String filePath;
	
	@Column(name = "orig_file_name", length = 128)
	private String origFileName;
	
	@Column(name = "study_info_id", length = 128)
	private String studyInfoId;
	
	@Column(name = "user_id", length = 128)
	private String userId;
	
	@Column(name = "media_id", length = 128)
	private String mediaId;
	
	/**
	 * 0:initial, 1:parse success，2:parse failed
	 */
	@Column(name = "status", length = 4)
	private String status;
	
	@Column(name = "failed_reason", length = 256)
	private String failedReason;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "update_time")
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
