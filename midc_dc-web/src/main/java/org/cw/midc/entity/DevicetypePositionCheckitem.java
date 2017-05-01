package org.cw.midc.entity;

import java.util.Date;

import org.cw.midc.BaseEntity;

public class DevicetypePositionCheckitem extends BaseEntity{
    private Integer id;

    private Integer checkitemId;

    private Date createTime;

    private String deviceTypeId;

    private String operId;

    private Integer positiontypeId;

    private Date updateTime;

    private String devicetypename;

    private String checkitemname;

    private String positiontypename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheckitemId() {
        return checkitemId;
    }

    public void setCheckitemId(Integer checkitemId) {
        this.checkitemId = checkitemId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId == null ? null : deviceTypeId.trim();
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId == null ? null : operId.trim();
    }


    public Integer getPositiontypeId() {
		return positiontypeId;
	}

	public void setPositiontypeId(Integer positiontypeId) {
		this.positiontypeId = positiontypeId;
	}

	public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDevicetypename() {
        return devicetypename;
    }

    public void setDevicetypename(String devicetypename) {
        this.devicetypename = devicetypename == null ? null : devicetypename.trim();
    }

    public String getCheckitemname() {
        return checkitemname;
    }

    public void setCheckitemname(String checkitemname) {
        this.checkitemname = checkitemname == null ? null : checkitemname.trim();
    }

    public String getPositiontypename() {
        return positiontypename;
    }

    public void setPositiontypename(String positiontypename) {
        this.positiontypename = positiontypename == null ? null : positiontypename.trim();
    }
}