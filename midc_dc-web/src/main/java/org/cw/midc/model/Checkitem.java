package org.cw.midc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "checkitem")
public class Checkitem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "checkitem_id", length = 32)
	private int checkitemId;
	
	@Column(name = "checkitem_name", length = 64)
	private String checkitemName;
	
	@Column(name = "is_available", length = 4)
	private String isAvailable;
	
	@Column(name = "oper_id", length = 32)
	private String operId;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "update_time")
	private Date updateTime;

	public int getCheckitemId() {
		return checkitemId;
	}

	public void setCheckitemId(int checkitemId) {
		this.checkitemId = checkitemId;
	}

	public String getCheckitemName() {
		return checkitemName;
	}

	public void setCheckitemName(String checkitemName) {
		this.checkitemName = checkitemName;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
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
