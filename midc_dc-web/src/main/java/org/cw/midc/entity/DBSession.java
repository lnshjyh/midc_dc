package org.cw.midc.entity;

import java.io.Serializable;

import org.cw.midc.BaseEntity;

public class DBSession extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2461330461545937334L;
	private String sessionid;
	private byte[] sessiondata;
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public byte[] getSessiondata() {
		return sessiondata;
	}
	public void setSessiondata(byte[] sessiondata) {
		this.sessiondata = sessiondata;
	}
	
	
	
}
