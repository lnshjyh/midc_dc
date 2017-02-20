package org.cw.midc.model.storage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="media_info")
public class MediaInfo {
	@Id
	@Column(name = "media_id", length = 128)
	private String id;
	
	@Column(name = "media_name", length = 128)
	private String name;
	
	@Column(name = "path", length = 128)
	private String path;
	
	/**
	 * 0:offline; 1: online
	 */
	@Column(name = "status", length = 4)
	private String status;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "update_time")
	private Date updateTime;

	public MediaInfo()
	{
		
	}
	
	public MediaInfo(String id, String name, String path)
	{
		this.id = id;
		this.name = name;
		this.path = path;
		this.status = "1";
		this.createTime = new Date();
		this.updateTime = this.createTime;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
