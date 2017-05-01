package org.cw.midc.entity;

import java.util.Date;

import org.cw.midc.BaseEntity;

public class Positiontype extends BaseEntity{
    public Positiontype(Integer positiontypeId, String positiontypeName) {
		super();
		this.positiontypeId = positiontypeId;
		this.positiontypeName = positiontypeName;
	}

	private Integer positiontypeId;

    private Date createTime;

    private String isAvailable;

    private String operId;

    private String positiontypeName;

    private Date updateTime;

    public Integer getPositiontypeId() {
        return positiontypeId;
    }

    public void setPositiontypeId(Integer positiontypeId) {
        this.positiontypeId = positiontypeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable == null ? null : isAvailable.trim();
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId == null ? null : operId.trim();
    }

    public String getPositiontypeName() {
        return positiontypeName;
    }

    public void setPositiontypeName(String positiontypeName) {
        this.positiontypeName = positiontypeName == null ? null : positiontypeName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}