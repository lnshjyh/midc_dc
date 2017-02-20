package org.cw.midc.model.ris;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "study_check_pos")
public class StudyCheckItemPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "study_cp_id", length = 256)
	private int id;
	
	@Column(name = "check_item", length = 256)
	private String checkItem;
	
	@Column(name = "position", length = 256)
	private String position;
	
	@Column(name = "sub_position", length = 256)
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
