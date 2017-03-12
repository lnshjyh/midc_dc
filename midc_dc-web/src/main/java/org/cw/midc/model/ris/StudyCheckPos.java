package org.cw.midc.model.ris;

import org.cw.midc.BaseEntity;

public class StudyCheckPos extends BaseEntity  {
	
	private int id;
	
	private String checkItem;
	
	private String position;
	
	private String subPosition;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
