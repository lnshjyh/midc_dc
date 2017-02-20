package org.cw.midc.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s_role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
//	@ManyToOne(fetch = FetchType.LAZY)   
//    private User SUser;//角色对应的用户实体  
	
	@Column(name="role_name", length=36, nullable = false)
	private String roleName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
/*	public User getSUser() {
		return SUser;
	}
	public void setSUser(User sUser) {
		SUser = sUser;
	}*/

}
