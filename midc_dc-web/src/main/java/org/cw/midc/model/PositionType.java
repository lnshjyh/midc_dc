package org.cw.midc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "positiontype")
public class PositionType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "positiontype_id", length = 32)
	private int positiontypeId;
	
	@Column(name = "positiontype_name", length = 64)
	private String positiontypeName;
	
	@Column(name = "is_available", length = 4)
	private String isAvailable;
	
	@Column(name = "oper_id", length = 32)
	private String operId;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "update_time")
	private Date updateTime;


	public int getPositiontypeId() {
		return positiontypeId;
	}

	public void setPositiontypeId(int positiontypeId) {
		this.positiontypeId = positiontypeId;
	}

	public String getPositiontypeName() {
		return positiontypeName;
	}

	public void setPositiontypeName(String positiontypeName) {
		this.positiontypeName = positiontypeName;
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
