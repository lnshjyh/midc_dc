package org.cw.midc.model.ris;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="study_info")
public class StudyInfo {

	@Id
	@Column(name = "studyinfo_id", length = 128)
	private String id;

	@Column(name = "age")
	private int age;
	
	/**
	 * 岁, 月，天
	 */
	@Column(name = "age_unit", length = 8)
	private String ageUnit;
	
	@Column(name = "device_id", length = 64)
	private String deviceId;
	
	@Column(name = "pre_diagnose", length = 512)
	private String preDiagnose;
	
	@Column(name = "abs_history", length = 512)
	private String abstractHistory;
	
	@Column(name = "study_desc", length = 512)
	private String studyDescription;
	
	@Column(name = "status", length = 4)
	private String status;
	
	@Column(name = "is_available", length = 4)
	private String isAvailable;
	
	@Column(name = "photo_maker_id", length = 128)
	private String photoMakerId;
	
	@Column(name = "branch_id", length = 128)
	private String branchId;
	
	@OneToOne
	@JoinColumn(name = "rpt_id")
	private Report report;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="pat_id")
	private Patient patient;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="studyinfo_id")
	private Set<StudyCheckItemPosition> studyCheckItemPositions;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "update_time")
	private Date updateTime;
	
	public StudyInfo()
	{
		this.createTime = new Date();
		this.updateTime = this.createTime;
		this.status = "0";
	}
	
	public StudyInfo(String key, 
			int age, 
			String 
			ageUnit, 
			String deviceId, 
			String preDiagnose, 
			String abstractHistory, 
			String studyDescription,
			String branchId)
	{
		this.id = key;
		this.age = age;
		this.ageUnit = ageUnit;
		this.deviceId = deviceId;
		this.preDiagnose = preDiagnose;
		this.abstractHistory = abstractHistory;
		this.studyDescription = studyDescription;
		this.branchId = branchId;
		this.isAvailable = "1";
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



	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
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
	
 
}
