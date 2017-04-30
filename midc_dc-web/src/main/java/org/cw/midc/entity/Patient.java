package org.cw.midc.entity;

import java.util.Date;

import org.cw.midc.BaseEntity;

public class Patient extends BaseEntity{
    private String patId;

    private String address;

    private Date birthday;

    private Date createTime;

    private String idNumber;

    private String nationality;

    private String operId;

    private String patCardId;

    private String patName;

    private String patSpellName;

    private String patientType;

    private String phoneNumber;

    private String sex;

    private Date updateTime;

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId == null ? null : patId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId == null ? null : operId.trim();
    }

    public String getPatCardId() {
        return patCardId;
    }

    public void setPatCardId(String patCardId) {
        this.patCardId = patCardId == null ? null : patCardId.trim();
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName == null ? null : patName.trim();
    }

    public String getPatSpellName() {
        return patSpellName;
    }

    public void setPatSpellName(String patSpellName) {
        this.patSpellName = patSpellName == null ? null : patSpellName.trim();
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType == null ? null : patientType.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}