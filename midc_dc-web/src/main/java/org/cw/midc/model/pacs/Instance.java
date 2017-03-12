package org.cw.midc.model.pacs;

import java.util.Date;

import org.cw.midc.BaseEntity;


public class Instance extends BaseEntity  {

	private String instanceUId;

	private String sopInstanceUId;

	private String seriesUniqueId;

	private String instanceNumber;

	private String fileId;
	
	private Date acquisitionDateTime;

	private Date createTime;
	
	public Instance()
	{
		this.createTime = new Date();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getInstanceUId() {
		return instanceUId;
	}

	public void setInstanceUId(String instanceUId) {
		this.instanceUId = instanceUId;
	}

	public String getSeriesUniqueId() {
		return seriesUniqueId;
	}

	public void setSeriesUniqueId(String seriesUniqueId) {
		this.seriesUniqueId = seriesUniqueId;
	}

	public String getInstanceNumber() {
		return instanceNumber;
	}

	public void setInstanceNumber(String instanceNumber) {
		this.instanceNumber = instanceNumber;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getSopInstanceUId() {
		return sopInstanceUId;
	}

	public void setSopInstanceUId(String sopInstanceUId) {
		this.sopInstanceUId = sopInstanceUId;
	}

	public Date getAcquisitionDateTime() {
		return acquisitionDateTime;
	}

	public void setAcquisitionDateTime(Date acquisitionDateTime) {
		this.acquisitionDateTime = acquisitionDateTime;
	}

}
