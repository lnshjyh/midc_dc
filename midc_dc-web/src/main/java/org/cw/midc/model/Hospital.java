package org.cw.midc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hospital")
public class Hospital {

	@Id
	@Column(name = "hosp_id", length = 32)
	 private String hospId;

	@Column(name = "hosp_name",length = 64)
    private String hospName;

	@Column(name = "address",length = 256)
    private String address;

	@Column(name = "longitude")
    private Float longitude;

	@Column(name = "latitude")
    private Float latitude;

	@Column(name = "client_id",length = 32)
    private String clientId;

	@Column(name = "client_secret",length = 64)
    private String clientSecret;

	@Column(name = "is_available",length = 4)
    private String isAvailable;

	@Column(name = "is_connected",length = 4)
    private String isConnected;

	@Column(name = "last_hb_time")
    private Date lastHbTime;

	@Column(name = "create_time")
    private Date createTime;

	@Column(name = "update_time")
    private Date updateTime;
	
	public Hospital(){
		this.createTime = new Date();
		this.updateTime = new Date();
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
