package org.cw.midc.model.pacs;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.cw.midc.BaseEntity;


public class Study extends BaseEntity {
	
	private String studyUniqueId;
		
	private String studyInstanceUId;
	
	private String userId;
	
	private String patientId;
	
	private String patientSex;
	
	private String patientName;
	
	private Date patientBirthday;
	
	private Float patientWeight;
	
	private Float patientSize;
	
	private String patientAge;
	
	private String accessNo;
	
	private String studyDescription;
	
	private Date studyTime;
	
	private String modality;
	
	private Set<Series> serieses = new HashSet<Series>();
	
	private String studyId;
	
	private String status;

	private Integer instanceCout;

	
	private Date createTime;
	
	public Study()
	{
		this.createTime = new Date();
		this.status = "1";
	}
	
	public void addSeries(Series series)
	{
		if(!serieses.contains(series))
		{
			this.serieses.add(series);
		}
	}
	
	public String getStudyUniqueId() {
		return studyUniqueId;
	}

	public void setStudyUniqueId(String studyUniqueId) {
		this.studyUniqueId = studyUniqueId;
	}

	public String getStudyInstanceUId() {
		return studyInstanceUId;
	}

	public void setStudyInstanceUId(String studyInstanceUId) {
		this.studyInstanceUId = studyInstanceUId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientSex() {
		return patientSex;
	}

	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public String getAccessNo() {
		return accessNo;
	}

	public void setAccessNo(String accessNo) {
		this.accessNo = accessNo;
	}

	public String getStudyDescription() {
		return studyDescription;
	}

	public void setStudyDescription(String studyDescription) {
		this.studyDescription = studyDescription;
	}

	public Date getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(Date studyTime) {
		this.studyTime = studyTime;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public Integer getInstanceCout() {
		return instanceCout;
	}

	public void setInstanceCout(Integer instanceCout) {
		this.instanceCout = instanceCout;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Set<Series> getSerieses() {
		return serieses;
	}

	public void setSerieses(Set<Series> serieses) {
		this.serieses = serieses;
	}

	public Date getPatientBirthday() {
		return patientBirthday;
	}

	public void setPatientBirthday(Date patientBirthday) {
		this.patientBirthday = patientBirthday;
	}

	public Float getPatientWeight() {
		return patientWeight;
	}

	public void setPatientWeight(Float patientWeight) {
		this.patientWeight = patientWeight;
	}

	public Float getPatientSize() {
		return patientSize;
	}

	public void setPatientSize(Float patientSize) {
		this.patientSize = patientSize;
	}

	public String getStudyId() {
		return studyId;
	}

	public void setStudyId(String studyId) {
		this.studyId = studyId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
