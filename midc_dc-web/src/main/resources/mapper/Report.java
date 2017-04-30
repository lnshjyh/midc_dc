package org.cw.midc.entity;

import java.util.Date;

public class Report {
    private String rptId;

    private String advice;

    private Date createTime;

    private String diagnosis;

    private String dDocId;

    private String jDocId;

    private String sDocId;

    private String status;

    private String studyinfoId;

    private Date updateTime;

    private String description;

    private String deviceType;

    public String getRptId() {
        return rptId;
    }

    public void setRptId(String rptId) {
        this.rptId = rptId == null ? null : rptId.trim();
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }

    public String getdDocId() {
        return dDocId;
    }

    public void setdDocId(String dDocId) {
        this.dDocId = dDocId == null ? null : dDocId.trim();
    }

    public String getjDocId() {
        return jDocId;
    }

    public void setjDocId(String jDocId) {
        this.jDocId = jDocId == null ? null : jDocId.trim();
    }

    public String getsDocId() {
        return sDocId;
    }

    public void setsDocId(String sDocId) {
        this.sDocId = sDocId == null ? null : sDocId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStudyinfoId() {
        return studyinfoId;
    }

    public void setStudyinfoId(String studyinfoId) {
        this.studyinfoId = studyinfoId == null ? null : studyinfoId.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }
}