package org.cw.midc.entity;

import java.util.Date;
import java.util.List;

import org.cw.midc.BaseEntity;

public class StudyInfo extends BaseEntity{
    private String studyinfoId;

    private String absHistory;

    private Integer age;

    private String ageUnit;

    private String applyDepName;

    private String applyDocName;

    private Date applyTime;

    private String clinicalManifest;

    private Date createTime;

    private String hospId;

    private String isAvailable;

    private String orgStudyinfoId;

    private String photoMakerId;

    private String positionCheckitem;

    private String preDiagnose;

    private String rptStatus;

    private String status;

    private String studyDemand;

    private String studyDesc;

    private String transStatus;

    private Date updateTime;

    private String patId;

    private String rptId;

    private String deviceType;
    
    private Patient patient;
    
    private Date studyTime;
    
    private List<StudyCheckPos> studyCheckPoses;
    
	public StudyInfo()
	{
		this.createTime = new Date();
		this.updateTime = this.createTime;
		this.status = "0";
		this.transStatus = "1";
	}
	
	public StudyInfo(String key, 
			int age, 
			String 
			ageUnit, 
			String deviceType, 
			String preDiagnose, 
			String abstractHistory, 
			String studyDescription,
			String hospitalId)
	{
		this.studyinfoId = key;
		this.age = age;
		this.ageUnit = ageUnit;
		this.deviceType = deviceType;
		this.preDiagnose = preDiagnose;
		this.absHistory = abstractHistory;
		this.studyDesc = studyDescription;
		this.hospId = hospitalId;
		this.isAvailable = "1";
		this.createTime = new Date();
		this.updateTime = this.createTime;
		this.status = "0";
		this.transStatus = "1";
	}

    public String getStudyinfoId() {
        return studyinfoId;
    }

    public void setStudyinfoId(String studyinfoId) {
        this.studyinfoId = studyinfoId == null ? null : studyinfoId.trim();
    }

    public String getAbsHistory() {
        return absHistory;
    }

    public void setAbsHistory(String absHistory) {
        this.absHistory = absHistory == null ? null : absHistory.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAgeUnit() {
        return ageUnit;
    }

    public void setAgeUnit(String ageUnit) {
        this.ageUnit = ageUnit == null ? null : ageUnit.trim();
    }

    public String getApplyDepName() {
        return applyDepName;
    }

    public void setApplyDepName(String applyDepName) {
        this.applyDepName = applyDepName == null ? null : applyDepName.trim();
    }

    public String getApplyDocName() {
        return applyDocName;
    }

    public void setApplyDocName(String applyDocName) {
        this.applyDocName = applyDocName == null ? null : applyDocName.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getClinicalManifest() {
        return clinicalManifest;
    }

    public void setClinicalManifest(String clinicalManifest) {
        this.clinicalManifest = clinicalManifest == null ? null : clinicalManifest.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHospId() {
        return hospId;
    }

    public void setHospId(String hospId) {
        this.hospId = hospId == null ? null : hospId.trim();
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable == null ? null : isAvailable.trim();
    }

    public String getOrgStudyinfoId() {
        return orgStudyinfoId;
    }

    public void setOrgStudyinfoId(String orgStudyinfoId) {
        this.orgStudyinfoId = orgStudyinfoId == null ? null : orgStudyinfoId.trim();
    }

    public String getPhotoMakerId() {
        return photoMakerId;
    }

    public void setPhotoMakerId(String photoMakerId) {
        this.photoMakerId = photoMakerId == null ? null : photoMakerId.trim();
    }

    public String getPositionCheckitem() {
        return positionCheckitem;
    }

    public void setPositionCheckitem(String positionCheckitem) {
        this.positionCheckitem = positionCheckitem == null ? null : positionCheckitem.trim();
    }

    public String getPreDiagnose() {
        return preDiagnose;
    }

    public void setPreDiagnose(String preDiagnose) {
        this.preDiagnose = preDiagnose == null ? null : preDiagnose.trim();
    }

    public String getRptStatus() {
        return rptStatus;
    }

    public void setRptStatus(String rptStatus) {
        this.rptStatus = rptStatus == null ? null : rptStatus.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStudyDemand() {
        return studyDemand;
    }

    public void setStudyDemand(String studyDemand) {
        this.studyDemand = studyDemand == null ? null : studyDemand.trim();
    }

    public String getStudyDesc() {
        return studyDesc;
    }

    public void setStudyDesc(String studyDesc) {
        this.studyDesc = studyDesc == null ? null : studyDesc.trim();
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus == null ? null : transStatus.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId == null ? null : patId.trim();
    }

    public String getRptId() {
        return rptId;
    }

    public void setRptId(String rptId) {
        this.rptId = rptId == null ? null : rptId.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<StudyCheckPos> getStudyCheckPoses() {
		return studyCheckPoses;
	}

	public void setStudyCheckPoses(List<StudyCheckPos> studyCheckPoses) {
		this.studyCheckPoses = studyCheckPoses;
	}

	public Date getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(Date studyTime) {
		this.studyTime = studyTime;
	}


    
    
}