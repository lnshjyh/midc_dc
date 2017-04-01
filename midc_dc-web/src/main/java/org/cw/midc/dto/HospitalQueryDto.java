package org.cw.midc.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class HospitalQueryDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1704766668076355811L;
	
	private String hospitalId;

    private String hospitalName;

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	
}
