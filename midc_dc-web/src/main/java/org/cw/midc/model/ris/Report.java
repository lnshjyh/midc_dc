package org.cw.midc.model.ris;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class Report {

	@Id
	@Column(name = "rpt_id", length = 64)
	private String id;
	
	@Column(name = "descritpion", length = 4000)
	private String descritpion;
	
	@Column(name = "diagnosis", length = 4000)
	private String diagnosis;
	
	@Column(name = "advice", length = 4000)
	private String advice;
	
	@Column(name = "j_doc_id", length = 64)
	private String juniorDoctorId;
	
	@Column(name = "s_doc_id", length = 64)
	private String seniorDoctorId;
	
	@Column(name = "d_doc_id", length = 64)
	private String directoDoctorId;
	
	@Column(name = "status", length = 4)
	private String status;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "update_time")
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getJuniorDoctorId() {
		return juniorDoctorId;
	}

	public void setJuniorDoctorId(String juniorDoctorId) {
		this.juniorDoctorId = juniorDoctorId;
	}

	public String getSeniorDoctorId() {
		return seniorDoctorId;
	}

	public void setSeniorDoctorId(String seniorDoctorId) {
		this.seniorDoctorId = seniorDoctorId;
	}

	public String getDirectoDoctorId() {
		return directoDoctorId;
	}

	public void setDirectoDoctorId(String directoDoctorId) {
		this.directoDoctorId = directoDoctorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
