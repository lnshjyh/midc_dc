package org.cw.midc.model.pacs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="series")
public class Series {

	@Id
	@Column(name = "series_uid", length = 128)
	private String seriesUniqueId;

//	@ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
//	@JoinColumn(name="study_uid")
	@Transient
	private Study study;
	
	@Column(name = "study_uid", length = 128)
	private String studyUniqueId;
	
	@Column(name = "series_iuid", length = 128)
	private String seriesInstanceUId;
	
	@Column(name = "series_no", length = 128)
	private String seriesNo;
	
	@Column(name = "series_desc", length = 128)
	private String seriesDescription;
	
	@Column(name = "body_part", length = 128)
	private String bodyPart;
	
	@Column(name = "image_count")
	private Integer imageCount;
	
	@Column(name = "create_time")
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
