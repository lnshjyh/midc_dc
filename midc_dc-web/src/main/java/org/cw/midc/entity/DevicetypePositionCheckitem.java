package org.cw.midc.entity;

import java.util.Date;

import org.cw.midc.BaseEntity;

public class DevicetypePositionCheckitem extends BaseEntity{
    public DevicetypePositionCheckitem() {
	}

	private Integer id;

    private Integer checkitemId;

    private Date createTime;

    private String deviceTypeId;

    private String operId;

    private Integer positiontypeId;

    private Date updateTime;

    private String devicetypeName;

    private String checkitemName;

    private String positiontypeName;

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

	public String getDevicetypeName() {
		return devicetypeName;
	}

	public void setDevicetypeName(String devicetypeName) {
		this.devicetypeName = devicetypeName;
	}

	public String getCheckitemName() {
		return checkitemName;
	}

	public void setCheckitemName(String checkitemName) {
		this.checkitemName = checkitemName;
	}

	public String getPositiontypeName() {
		return positiontypeName;
	}

	public void setPositiontypeName(String positiontypeName) {
		this.positiontypeName = positiontypeName;
	}
    
    

}