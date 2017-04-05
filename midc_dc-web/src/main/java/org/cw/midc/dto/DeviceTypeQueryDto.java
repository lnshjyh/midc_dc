package org.cw.midc.dto;

import java.io.Serializable;

public class DeviceTypeQueryDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7722149782215215405L;
	
	private String deviceTypeId;
	
	private String deviceTypeName;

	public String getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public String getDeviceTypeName() {
		return deviceTypeName;
	}

	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}
	
	

}
