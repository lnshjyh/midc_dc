package org.cw.midc.model.pacs;

import java.util.Date;

import org.cw.midc.BaseEntity;


public class Series extends BaseEntity  {

	private String seriesUniqueId;

	private Study study;
	
	private String studyUniqueId;
	
	private String seriesInstanceUId;
	
	private String seriesNo;
	
	private String seriesDescription;
	
	private String bodyPart;
	
	private Integer imageCount;
	
	private Date createTime;
	
	public Series()
	{
		this.createTime = new Date();
		this.imageCount = 0;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSeriesUniqueId() {
		return seriesUniqueId;
	}

	public void setSeriesUniqueId(String seriesUniqueId) {
		this.seriesUniqueId = seriesUniqueId;
	}

	
	public String getStudyUniqueId() {
		return studyUniqueId;
	}

	public void setStudyUniqueId(String studyUniqueId) {
		this.studyUniqueId = studyUniqueId;
	}

	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	public String getSeriesInstanceUId() {
		return seriesInstanceUId;
	}

	public void setSeriesInstanceUId(String seriesInstanceUId) {
		this.seriesInstanceUId = seriesInstanceUId;
	}

	public String getSeriesDescription() {
		return seriesDescription;
	}

	public void setSeriesDescription(String seriesDescription) {
		this.seriesDescription = seriesDescription;
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

	public String getSeriesNo() {
		return seriesNo;
	}

	public void setSeriesNo(String seriesNo) {
		this.seriesNo = seriesNo;
	}

	public Integer getImageCount() {
		return imageCount;
	}

	public void setImageCount(Integer imageCount) {
		this.imageCount = imageCount;
	}	
}
