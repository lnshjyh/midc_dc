package org.cw.midc.model.pacs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instance")
public class Instance {

	@Id
	@Column(name = "instance_uid", length = 128)
	private String instanceUId;

	@Column(name = "sop_iuid", length = 128)
	private String sopInstanceUId;

	@Column(name = "series_uid", length = 128)
	private String seriesUniqueId;

	@Column(name = "inst_no", length = 128)
	private String instanceNumber;

	@Column(name = "file_id", length = 128)
	private String fileId;
	
	@Column(name = "acq_date_time")
	private Date acquisitionDateTime;

	@Column(name = "create_time")
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
