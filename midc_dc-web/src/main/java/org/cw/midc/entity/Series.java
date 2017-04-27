package org.cw.midc.entity;

import java.util.Date;

import org.cw.midc.BaseEntity;

public class Series  extends BaseEntity{
    private String seriesUid;

    private String bodyPart;

    private Date createTime;

    private Integer imageCount;

    private String seriesDesc;

    private String seriesIuid;

    private String seriesNo;

    private String studyUid;
    
	public Series()
	{
		this.createTime = new Date();
		this.imageCount = 0;
	}

    public String getSeriesUid() {
        return seriesUid;
    }

    public void setSeriesUid(String seriesUid) {
        this.seriesUid = seriesUid == null ? null : seriesUid.trim();
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart == null ? null : bodyPart.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getImageCount() {
        return imageCount;
    }

    public void setImageCount(Integer imageCount) {
        this.imageCount = imageCount;
    }

    public String getSeriesDesc() {
        return seriesDesc;
    }

    public void setSeriesDesc(String seriesDesc) {
        this.seriesDesc = seriesDesc == null ? null : seriesDesc.trim();
    }

    public String getSeriesIuid() {
        return seriesIuid;
    }

    public void setSeriesIuid(String seriesIuid) {
        this.seriesIuid = seriesIuid == null ? null : seriesIuid.trim();
    }

    public String getSeriesNo() {
        return seriesNo;
    }

    public void setSeriesNo(String seriesNo) {
        this.seriesNo = seriesNo == null ? null : seriesNo.trim();
    }

    public String getStudyUid() {
        return studyUid;
    }

    public void setStudyUid(String studyUid) {
        this.studyUid = studyUid == null ? null : studyUid.trim();
    }
}