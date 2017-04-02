package org.cw.midc.entity;

import java.util.Date;

import org.cw.midc.BaseEntity;

public class StudyInfoEntity extends BaseEntity {
	private String id;

	private int age;
	
	/**
	 * 岁, 月，天
	 */
	private String ageUnit;
	
	private String deviceId;
	
	private String preDiagnose;
	
	private String abstractHistory;
	
	private String studyDescription;
	
	private String status;
	
	private String isAvailable;
	
	private String photoMakerId;
	
	private String branchId;
	
	
	private Date createTime;
	
	private Date updateTime;
	
	public StudyInfoEntity()
	{
		this.createTime = new Date();
		this.updateTime = this.createTime;
		this.status = "0";
	}


	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAgeUnit() {
		return ageUnit;
	}

	public void setAgeUnit(String ageUnit) {
		this.ageUnit = ageUnit;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getPreDiagnose() {
		return preDiagnose;
	}

	public void setPreDiagnose(String preDiagnose) {
		this.preDiagnose = preDiagnose;
	}

	public String getAbstractHistory() {
		return abstractHistory;
	}

	public void setAbstractHistory(String abstractHistory) {
		this.abstractHistory = abstractHistory;
	}

	public String getStudyDescription() {
		return studyDescription;
	}

	public void setStudyDescription(String studyDescription) {
		this.studyDescription = studyDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getPhotoMakerId() {
		return photoMakerId;
	}

	public void setPhotoMakerId(String photoMakerId) {
		this.photoMakerId = photoMakerId;
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

}
