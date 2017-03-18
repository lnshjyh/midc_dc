package org.cw.midc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Ris信息修改
 * @author cloud
 *
 */
public class RisInfoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8868141563990359835L;

	private String studyInfoId;
	
	//patient information
	private String patientName;
	private String patientSpellName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String sex;
	private String patientType;
	private String idNumber;
	private String phoneNumber;
	private String nationality;
	private String address;
	private String patientCardId;
	private String operatorId;

	//study information
	private int age;
	private String ageUnit;
	private String deviceId;

	private String status;
	private String isAvailable;
	private String photoMakeId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date studyTime;
	
	//申请单信息
	private String prediagnose;
	private String abstractHistory;
	private String studyDescription;
	private String clinicalManifest;
	private String studyDemand;
	private String applyDoctorName;
	private String applyDepartmentName;	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date applyTime;
	
	//position and checktitem
	private List<PositionCheck> positionChecks;
	
	private String hospitalId;
	
	
		
	public List<PositionCheck> getPositionChecks() {
		return positionChecks;
	}
	public void setPositionCheckDtos(List<PositionCheck> positionChecks) {
		this.positionChecks = positionChecks;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSpellName() {
		return patientSpellName;
	}
	public void setPatientSpellName(String patientSpellName) {
		this.patientSpellName = patientSpellName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPatientCardId() {
		return patientCardId;
	}
	public void setPatientCardId(String patientCardId) {
		this.patientCardId = patientCardId;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAgeUnit() {
		return ageUnit;
	}
	public void setAgeUnit(String ageUnit) {
		this.ageUnit = ageUnit;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getPrediagnose() {
		return prediagnose;
	}
	public void setPrediagnose(String prediagnose) {
		this.prediagnose = prediagnose;
	}
	public String getAbstractHistory() {
		return abstractHistory;
	}
	public void setAbstractHistory(String abstractHistory) {
		this.abstractHistory = abstractHistory;
	}
	public String getStudyDescription() {
		return studyDescription;
	}
	public void setStudyDescription(String studyDescription) {
		this.studyDescription = studyDescription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getPhotoMakeId() {
		return photoMakeId;
	}
	public void setPhotoMakeId(String photoMakeId) {
		this.photoMakeId = photoMakeId;
	}
	public Date getStudyTime() {
		return studyTime;
	}
	public void setStudyTime(Date studyTime) {
		this.studyTime = studyTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPatientType() {
		return patientType;
	}
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}
	public void setPositionChecks(List<PositionCheck> positionChecks) {
		this.positionChecks = positionChecks;
	}
	public String getClinicalManifest() {
		return clinicalManifest;
	}
	public void setClinicalManifest(String clinicalManifest) {
		this.clinicalManifest = clinicalManifest;
	}
	public String getStudyDemand() {
		return studyDemand;
	}
	public void setStudyDemand(String studyDemand) {
		this.studyDemand = studyDemand;
	}
	public String getApplyDoctorName() {
		return applyDoctorName;
	}
	public void setApplyDoctorName(String applyDoctorName) {
		this.applyDoctorName = applyDoctorName;
	}
	public String getApplyDepartmentName() {
		return applyDepartmentName;
	}
	public void setApplyDepartmentName(String applyDepartmentName) {
		this.applyDepartmentName = applyDepartmentName;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getStudyInfoId() {
		return studyInfoId;
	}
	public void setStudyInfoId(String studyInfoId) {
		this.studyInfoId = studyInfoId;
	}

	
	
	
}
