package org.cw.midc.entity;

import java.io.Serializable;

import org.cw.midc.BaseEntity;

public class DBSession extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2461330461545937334L;
	private String sessionid;
	private byte[] session;
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public byte[] getSession() {
		return session;
	}
	public void setSession(byte[] session) {
		this.session = session;
	}
	
	
}
