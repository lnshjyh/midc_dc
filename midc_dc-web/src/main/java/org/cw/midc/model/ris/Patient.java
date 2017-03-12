package org.cw.midc.model.ris;

import java.util.Date;
import java.util.Set;

import org.cw.midc.BaseEntity;

public class Patient extends BaseEntity  {
	private String id;
	
	private String patientName;
	
	private String patientSpellName;
	
	private Date birthday;
	
	/**
	 * M, F, O
	 */
	private String sex;
	
	/**
	 * 1: 平诊， 2：急诊
	 */
	private String patientType;
	
	private String idNumber;
	
	private String phoneNumber;
	
	private String nationality;
	
	private String address;
	
	private String patientCardId;
	
	private Set<StudyInfo> StudyInfos;
	
	private String operatorId;
	
	private Date createTime;
	
	private Date updateTime;
	
	public Patient()
	{
		
	}
	
	public Patient(String id, 
			String patientName, 
			String patientSpellName, 
			Date birthday, 
			String sex, 
			String patientType,
			String idNumber, 
			String phoneNumber, 
			String nationality, 
			String address, 
			String patientCardId, 
			String operatorId)
	{
		this.id = id;
		this.patientName = patientName;
		this.patientSpellName = patientSpellName;
		this.birthday = birthday;
		this.sex = sex;
		this.patientType = patientType;
		this.idNumber = idNumber;
		this.phoneNumber = phoneNumber;
		this.nationality = nationality;
		this.address = address;
		this.patientCardId = patientCardId;
		this.operatorId = operatorId;
		this.createTime = new Date();
		this.updateTime = this.createTime;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientSpellName() {
		return patientSpellName;
	}

	public void setPatientSpellName(String patientSpellName) {
		this.patientSpellName = patientSpellName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPatientCardId() {
		return patientCardId;
	}

	public void setPatientCardId(String patientCardId) {
		this.patientCardId = patientCardId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
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

	public String getPatientType() {
		return patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	public Set<StudyInfo> getStudyInfos() {
		return StudyInfos;
	}

	public void setStudyInfos(Set<StudyInfo> studyInfos) {
		StudyInfos = studyInfos;
	}
	
	
}
