package org.cw.midc.entity;

import java.util.Date;

import org.cw.midc.BaseEntity;

public class CheckItem extends BaseEntity{
    public CheckItem(Integer checkitemId, String checkitemName) {
		super();
		this.checkitemId = checkitemId;
		this.checkitemName = checkitemName;
	}

    public CheckItem(){
    	
    }
	private Integer checkitemId;

    public CheckItem(Integer checkitemId, String checkitemName, Date createTime, String isAvailable, String operId,
			Date updateTime) {
		super();
		this.checkitemId = checkitemId;
		this.checkitemName = checkitemName;
		this.createTime = createTime;
		this.isAvailable = isAvailable;
		this.operId = operId;
		this.updateTime = updateTime;
	}

	private String checkitemName;

    private Date createTime;

    private String isAvailable;

    private String operId;

    private Date updateTime;

    public Integer getCheckitemId() {
        return checkitemId;
    }

    public void setCheckitemId(Integer checkitemId) {
        this.checkitemId = checkitemId;
    }

    public String getCheckitemName() {
        return checkitemName;
    }

    public void setCheckitemName(String checkitemName) {
        this.checkitemName = checkitemName == null ? null : checkitemName.trim();
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}