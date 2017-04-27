package org.cw.midc.entity.ris;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.cw.midc.BaseEntity;

public class StudyInfo  extends BaseEntity {

	private String id;
	
	private String orginalStudyInfoId;

	private int age;
	
	private String ageUnit;
	
	private String deviceType;
	
	private String positionCheckItem;
	
	private String preDiagnose;
	
	private String abstractHistory;
	
	private String studyDescription;
	
	private String clinicalManifest;
	
	private String studyDemand;
	
	//报告状态: 0：未写，1：初诊，2：审核完毕',
	private String reportStatus;
	
	//传输状态：1：基层到中心 2：中心到基层',
	private String transportStatus;
	
	private String status;
	
	private String isAvailable;
	
	private String applyDoctorName;
	
	private String applyDepartmentName;
	
	private Date applyTime;
	
	private String photoMakerId;
	
	private String hospitalId;
	
//	private Report report;
	
	private Patient patient;
	
	private Set<StudyCheckItemPosition> studyCheckItemPositions;
	
//	private Set<Study> studies = new HashSet<Study>();
	
	
	
	private Date createTime;
	
	private Date updateTime;
	
	public StudyInfo()
	{
		this.createTime = new Date();
		this.updateTime = this.createTime;
		this.status = "0";
		this.transportStatus = "1";
	}
	
	public StudyInfo(String key, 
			int age, 
			String 
			ageUnit, 
			String deviceType, 
			String preDiagnose, 
			String abstractHistory, 
			String studyDescription,
			String hospitalId)
	{
		this.id = key;
		this.age = age;
		this.ageUnit = ageUnit;
		this.deviceType = deviceType;
		this.preDiagnose = preDiagnose;
		this.abstractHistory = abstractHistory;
		this.studyDescription = studyDescription;
		this.hospitalId = hospitalId;
		this.isAvailable = "1";
		this.createTime = new Date();
		this.updateTime = this.createTime;
		this.status = "0";
		this.transportStatus = "1";
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	/*public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}*/

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



	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Set<StudyCheckItemPosition> getStudyCheckItemPositions() {
		return studyCheckItemPositions;
	}

	public void setStudyCheckItemPositions(Set<StudyCheckItemPosition> studyCheckItemPositions) {
		this.studyCheckItemPositions = studyCheckItemPositions;
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

	public String getOrginalStudyInfoId() {
		return orginalStudyInfoId;
	}

	public void setOrginalStudyInfoId(String orginalStudyInfoId) {
		this.orginalStudyInfoId = orginalStudyInfoId;
	}

	/*public Set<Study> getStudies() {
		return studies;
	}

	public void setStudies(Set<Study> studies) {
		this.studies = studies;
	}*/

	public String getPositionCheckItem() {
		return positionCheckItem;
	}

	public void setPositionCheckItem(String positionCheckItem) {
		this.positionCheckItem = positionCheckItem;
	}
	
	
	
 
}
