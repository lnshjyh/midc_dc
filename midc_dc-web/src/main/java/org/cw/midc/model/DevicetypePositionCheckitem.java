package org.cw.midc.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.cw.midc.model.ris.StudyCheckItemPosition;

@Entity
@Table(name = "devicetype_position_checkitem")
public class DevicetypePositionCheckitem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 32)
	private int id;
	
//	@Column(name = "device_type", length = 64)
	private String deviceTypePk;
//	
//	@Column(name = "position_id", length = 32)
	private Integer positionIdPk;
//	
//	@Column(name = "checkitem_id", length = 32)
	private Integer checkitemIdPk;
	
	@Column(name = "oper_id", length = 32)
	private String operId;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "update_time")
	private Date updateTime;
	
	@ManyToOne(cascade=CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name="checkitem_id")
	private Checkitem checkitem;
	
	@ManyToOne(cascade=CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name="device_type")
	private DeviceType device;
	
	@ManyToOne(cascade=CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name="position_id")
	private PositionType positionType;

	

	public Checkitem getCheckitem() {
		return checkitem;
	}

	public void setCheckitem(Checkitem checkitem) {
		this.checkitem = checkitem;
	}

	public DeviceType getDevice() {
		return device;
	}

	public void setDevice(DeviceType device) {
		this.device = device;
	}

	public PositionType getPositionType() {
		return positionType;
	}

	public void setPositionType(PositionType positionType) {
		this.positionType = positionType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getDeviceType() {
//		return deviceType;
//	}
//
//	public void setDeviceType(String deviceType) {
//		this.deviceType = deviceType;
//	}
//
//	public String getPositionId() {
//		return positionId;
//	}
//
//	public void setPositionId(String positionId) {
//		this.positionId = positionId;
//	}
//
//	public String getCheckitemId() {
//		return checkitemId;
//	}
//
//	public void setCheckitemId(String checkitemId) {
//		this.checkitemId = checkitemId;
//	}

	public String getDeviceTypePk() {
		return deviceTypePk;
	}

	public void setDeviceTypePk(String deviceTypePk) {
		this.deviceTypePk = deviceTypePk;
	}


	public Integer getPositionIdPk() {
		return positionIdPk;
	}

	public void setPositionIdPk(Integer positionIdPk) {
		this.positionIdPk = positionIdPk;
	}

	public Integer getCheckitemIdPk() {
		return checkitemIdPk;
	}

	public void setCheckitemIdPk(Integer checkitemIdPk) {
		this.checkitemIdPk = checkitemIdPk;
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
