package org.cw.midc.dto;

import java.io.Serializable;

public class PositionCheck implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8576001969242925861L;

	private String checkItem;
	private String position;
	private String subPosition;
	
	public String getCheckItem() {
		return checkItem;
	}
	public void setCheckItem(String checkItem) {
		this.checkItem = checkItem;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSubPosition() {
		return subPosition;
	}
	public void setSubPosition(String subPosition) {
		this.subPosition = subPosition;
	}
}
