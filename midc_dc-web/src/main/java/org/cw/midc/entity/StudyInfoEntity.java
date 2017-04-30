package org.cw.midc.entity;

import java.util.Date;
import java.util.Set;

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
	
	
	private String orginalStudyInfoId;

	
	
	private String deviceType;
	
	private String positionCheckItem;
	
	private String clinicalManifest;
	
	private String studyDemand;
	
	//报告状态: 0：未写，1：初诊，2：审核完毕',
	private String reportStatus;
	
	//传输状态：1：基层到中心 2：中心到基层',
	private String transportStatus;
	
	
	private String applyDoctorName;
	
	private String applyDepartmentName;
	
	private Date applyTime;

	private String hospitalId;
	

	
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


	public String getOrginalStudyInfoId() {
		return orginalStudyInfoId;
	}


	public void setOrginalStudyInfoId(String orginalStudyInfoId) {
		this.orginalStudyInfoId = orginalStudyInfoId;
	}


	public String getDeviceType() {
		return deviceType;
	}


	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}


	public String getPositionCheckItem() {
		return positionCheckItem;
	}


	public void setPositionCheckItem(String positionCheckItem) {
		this.positionCheckItem = positionCheckItem;
	}


	public String getClinicalManifest() {
		return clinicalManifest;
	}


	public void setClinicalManifest(String clinicalManifest) {
		this.clinicalManifest = clinicalManifest;
	}


	public String getStudyDemand() {
		return studyDemand;
	}


	public void setStudyDemand(String studyDemand) {
		this.studyDemand = studyDemand;
	}


	public String getReportStatus() {
		return reportStatus;
	}


	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}


	public String getTransportStatus() {
		return transportStatus;
	}


	public void setTransportStatus(String transportStatus) {
		this.transportStatus = transportStatus;
	}


	public String getApplyDoctorName() {
		return applyDoctorName;
	}


	public void setApplyDoctorName(String applyDoctorName) {
		this.applyDoctorName = applyDoctorName;
	}


	public String getApplyDepartmentName() {
		return applyDepartmentName;
	}


	public void setApplyDepartmentName(String applyDepartmentName) {
		this.applyDepartmentName = applyDepartmentName;
	}


	public Date getApplyTime() {
		return applyTime;
	}


	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}


	public String getHospitalId() {
		return hospitalId;
	}


	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

}
