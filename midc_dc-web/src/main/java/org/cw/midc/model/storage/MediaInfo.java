package org.cw.midc.model.storage;

import java.util.Date;

import org.cw.midc.BaseEntity;


public class MediaInfo extends BaseEntity  {
	private String id;
	
	private String name;
	
	private String path;
	
	/**
	 * 0:offline; 1: online
	 */
	private String status;
	
	private Date createTime;
	
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
