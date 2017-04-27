package org.cw.midc.entity;

import java.util.Date;

import org.cw.midc.BaseEntity;

public class Instance extends BaseEntity {
    private String instanceUid;

    private Date acqDateTime;

    private Date createTime;

    private String fileId;

    private String instNo;

    private String seriesUid;

    private String sopIuid;
    
	public Instance()
	{
		this.createTime = new Date();
	}


    public String getInstanceUid() {
        return instanceUid;
    }

    public void setInstanceUid(String instanceUid) {
        this.instanceUid = instanceUid == null ? null : instanceUid.trim();
    }

    public Date getAcqDateTime() {
        return acqDateTime;
    }

    public void setAcqDateTime(Date acqDateTime) {
        this.acqDateTime = acqDateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public String getInstNo() {
        return instNo;
    }

    public void setInstNo(String instNo) {
        this.instNo = instNo == null ? null : instNo.trim();
    }

    public String getSeriesUid() {
        return seriesUid;
    }

    public void setSeriesUid(String seriesUid) {
        this.seriesUid = seriesUid == null ? null : seriesUid.trim();
    }

    public String getSopIuid() {
        return sopIuid;
    }

    public void setSopIuid(String sopIuid) {
        this.sopIuid = sopIuid == null ? null : sopIuid.trim();
    }
}