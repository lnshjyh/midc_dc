package org.cw.midc.model.pacs;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="study")
public class Study {
	
	@Id
	@Column(name = "study_uid", length = 128)
	private String studyUniqueId;
		
	@Column(name = "study_iuid", length = 128)
	private String studyInstanceUId;
	
	@Column(name = "user_id", length = 128)
	private String userId;
	
	@Column(name = "pat_id", length = 128)
	private String patientId;
	
	@Column(name = "pat_sex", length = 128)
	private String patientSex;
	
	@Column(name = "pat_name", length = 128)
	private String patientName;
	
	@Column(name = "pat_birth")
	private Date patientBirthday;
	
	@Column(name = "pat_weight")
	private Float patientWeight;
	
	@Column(name = "pat_size")
	private Float patientSize;
	
	@Column(name = "pat_age")
	private String patientAge;
	
	@Column(name = "access_no", length = 128)
	private String accessNo;
	
	@Column(name = "study_desc", length = 128)
	private String studyDescription;
	
	@Column(name = "study_time")
	private Date studyTime;
	
	@Column(name = "modality", length = 128)
	private String modality;
	
//	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy ="study")
//	@JoinColumn(name="study_uid")
	@Transient
	private Set<Series> serieses = new HashSet<Series>();
	
	@Column(name = "study_id", length = 128)
	private String studyId;
	
	@Column(name = "status", length = 8)
	private String status;

	@Column(name = "inst_cnt")
	private Integer instanceCout;

	
	@Column(name = "create_time")
	private Date createTime;
	
	public Study()
	{
		this.createTime = new Date();
		this.status = "1";
	}
	
	public void addSeries(Series series)
	{
		if(!serieses.contains(series))
		{
			this.serieses.add(series);
		}
	}
	
	public String getStudyUniqueId() {
		return studyUniqueId;
	}

	public void setStudyUniqueId(String studyUniqueId) {
		this.studyUniqueId = studyUniqueId;
	}

	public String getStudyInstanceUId() {
		return studyInstanceUId;
	}

	public void setStudyInstanceUId(String studyInstanceUId) {
		this.studyInstanceUId = studyInstanceUId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientSex() {
		return patientSex;
	}

	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public String getAccessNo() {
		return accessNo;
	}

	public void setAccessNo(String accessNo) {
		this.accessNo = accessNo;
	}

	public String getStudyDescription() {
		return studyDescription;
	}

	public void setStudyDescription(String studyDescription) {
		this.studyDescription = studyDescription;
	}

	public Date getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(Date studyTime) {
		this.studyTime = studyTime;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public Integer getInstanceCout() {
		return instanceCout;
	}

	public void setInstanceCout(Integer instanceCout) {
		this.instanceCout = instanceCout;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Set<Series> getSerieses() {
		return serieses;
	}

	public void setSerieses(Set<Series> serieses) {
		this.serieses = serieses;
	}

	public Date getPatientBirthday() {
		return patientBirthday;
	}

	public void setPatientBirthday(Date patientBirthday) {
		this.patientBirthday = patientBirthday;
	}

	public Float getPatientWeight() {
		return patientWeight;
	}

	public void setPatientWeight(Float patientWeight) {
		this.patientWeight = patientWeight;
	}

	public Float getPatientSize() {
		return patientSize;
	}

	public void setPatientSize(Float patientSize) {
		this.patientSize = patientSize;
	}

	public String getStudyId() {
		return studyId;
	}

	public void setStudyId(String studyId) {
		this.studyId = studyId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
