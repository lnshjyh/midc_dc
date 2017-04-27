package org.cw.midc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.cw.midc.BaseEntity;

public class Hospital  extends BaseEntity{

	 private String hospId;

    private String hospName;

    private String address;

    private Float longitude;

    private Float latitude;

    private String clientId;

    private String clientSecret;

    private String isAvailable;

    private String isConnected;

    private Date lastHbTime;

    private Date createTime;

    private Date updateTime;
	
	public Hospital(){
		this.createTime = new Date();
		this.updateTime = new Date();
		this.isAvailable = "1";
		this.isConnected = "0";
	}

    public String getHospId() {
        return hospId;
    }

    public void setHospId(String hospId) {
        this.hospId = hospId == null ? null : hospId.trim();
    }

    public String getHospName() {
        return hospName;
    }

    public void setHospName(String hospName) {
        this.hospName = hospName == null ? null : hospName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret == null ? null : clientSecret.trim();
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable == null ? null : isAvailable.trim();
    }

    public String getIsConnected() {
        return isConnected;
    }

    public void setIsConnected(String isConnected) {
        this.isConnected = isConnected == null ? null : isConnected.trim();
    }

    public Date getLastHbTime() {
        return lastHbTime;
    }

    public void setLastHbTime(Date lastHbTime) {
        this.lastHbTime = lastHbTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
