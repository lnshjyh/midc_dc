package org.cw.midc.entity;

import java.util.Date;

import org.cw.midc.BaseEntity;

public class Study extends BaseEntity{
    private String studyUid;

    private String accessNo;

    private Date createTime;

    private Integer instCnt;

    private String modality;

    private String patAge;

    private Date patBirth;

    private String patId;

    private String patName;

    private String patSex;

    private Float patSize;

    private Float patWeight;

    private String status;

    private String studyDesc;

    private String studyId;

    private String studyIuid;

    private Date studyTime;

    private String userId;
    
	public Study()
	{
		this.createTime = new Date();
		this.status = "1";
	}

    public String getStudyUid() {
        return studyUid;
    }

    public void setStudyUid(String studyUid) {
        this.studyUid = studyUid == null ? null : studyUid.trim();
    }

    public String getAccessNo() {
        return accessNo;
    }

    public void setAccessNo(String accessNo) {
        this.accessNo = accessNo == null ? null : accessNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getInstCnt() {
        return instCnt;
    }

    public void setInstCnt(Integer instCnt) {
        this.instCnt = instCnt;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality == null ? null : modality.trim();
    }

    public String getPatAge() {
        return patAge;
    }

    public void setPatAge(String patAge) {
        this.patAge = patAge == null ? null : patAge.trim();
    }

    public Date getPatBirth() {
        return patBirth;
    }

    public void setPatBirth(Date patBirth) {
        this.patBirth = patBirth;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId == null ? null : patId.trim();
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName == null ? null : patName.trim();
    }

    public String getPatSex() {
        return patSex;
    }

    public void setPatSex(String patSex) {
        this.patSex = patSex == null ? null : patSex.trim();
    }

    public Float getPatSize() {
        return patSize;
    }

    public void setPatSize(Float patSize) {
        this.patSize = patSize;
    }

    public Float getPatWeight() {
        return patWeight;
    }

    public void setPatWeight(Float patWeight) {
        this.patWeight = patWeight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStudyDesc() {
        return studyDesc;
    }

    public void setStudyDesc(String studyDesc) {
        this.studyDesc = studyDesc == null ? null : studyDesc.trim();
    }

    public String getStudyId() {
        return studyId;
    }

    public void setStudyId(String studyId) {
        this.studyId = studyId == null ? null : studyId.trim();
    }

    public String getStudyIuid() {
        return studyIuid;
    }

    public void setStudyIuid(String studyIuid) {
        this.studyIuid = studyIuid == null ? null : studyIuid.trim();
    }

    public Date getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(Date studyTime) {
        this.studyTime = studyTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}