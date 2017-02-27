package org.cw.midc.model.ris;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {
	@Id
	@Column(name = "pat_id", length = 64)
	private String id;
	
	@Column(name = "pat_name", length = 64, nullable = false)
	private String patientName;
	
	@Column(name = "pat_spell_name", length = 128)
	private String patientSpellName;
	
	@Column(name = "birthday")
	private Date birthday;
	
	/**
	 * M, F, O
	 */
	@Column(name = "sex", length = 4)
	private String sex;
	
	/**
	 * 1: 平诊， 2：急诊
	 */
	@Column(name = "patientType", length = 4)
	private String patientType;
	
	@Column(name = "id_number", length = 32)
	private String idNumber;
	
	@Column(name = "phone_number", length = 32)
	private String phoneNumber;
	
	@Column(name = "nationality", length = 128)
	private String nationality;
	
	@Column(name = "address", length = 512)
	private String address;
	
	@Column(name = "pat_card_id", length = 128)
	private String patientCardId;
	
	@OneToMany(mappedBy="patient",cascade=CascadeType.ALL)
	private Set<StudyInfo> StudyInfos;
	
	@Column(name = "oper_id", length = 64)
	private String operatorId;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "update_time")
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
