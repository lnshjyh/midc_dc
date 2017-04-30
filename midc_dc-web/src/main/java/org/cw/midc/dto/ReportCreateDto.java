package org.cw.midc.dto;

import java.io.Serializable;

public class ReportCreateDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5384232449878462532L;
	
	private String studyInfoId;
	
	private String description;
	
	private String diagnosis;
	
	private String advice;

	public String getStudyInfoId() {
		return studyInfoId;
	}

	public void setStudyInfoId(String studyInfoId) {
		this.studyInfoId = studyInfoId;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	

}
