package org.cw.midc.entity;

import org.cw.midc.BaseEntity;

public class Role extends BaseEntity {
	private String roleId;

	private String name;


	public String getRoleId( ) {
		return roleId;
	}

	public void setRoleId( String roleId ) {
		this.roleId = roleId;
	}

	public String getName( ) {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}
}
