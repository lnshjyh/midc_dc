package org.cw.midc.dto;

import java.io.Serializable;
import java.util.Date;

public class ReportQueryDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6327657864603870993L;

	private String id;

	private String studyInfoId;
	
	private String descritpion;
	
	private String diagnosis;
	
	private String advice;
	
	private String juniorDoctorId;
	
	private String seniorDoctorId;
	
	private String directoDoctorId;
	
	private Date createTime;
	
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudyInfoId() {
		return studyInfoId;
	}

	public void setStudyInfoId(String studyInfoId) {
		this.studyInfoId = studyInfoId;
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
