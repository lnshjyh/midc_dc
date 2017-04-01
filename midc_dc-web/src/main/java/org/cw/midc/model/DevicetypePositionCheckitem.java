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
	
	@Column(name = "device_type", length = 64)
	private String deviceType;
	
	@Column(name = "position_id", length = 32)
	private String positionId;
	
	@Column(name = "checkitem_id", length = 32)
	private String checkitemId;
	
	@Column(name = "oper_id", length = 32)
	private String operId;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "update_time")
	private Date updateTime;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="checkitem_id")
	private Checkitem checkitem;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="device_type_id")
	private DeviceType device;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="positiontype_id")
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

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getCheckitemId() {
		return checkitemId;
	}

	public void setCheckitemId(String checkitemId) {
		this.checkitemId = checkitemId;
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
