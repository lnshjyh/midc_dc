package org.cw.midc.dto;

import java.io.Serializable;

public class InstanceQueryDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String instanceUniqueId;
	String fileId;


	public String getInstanceUniqueId() {
		return instanceUniqueId;
	}

	public void setInstanceUniqueId(String instanceUniqueId) {
		this.instanceUniqueId = instanceUniqueId;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

}
