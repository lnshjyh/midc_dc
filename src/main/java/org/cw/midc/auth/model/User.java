package org.cw.midc.auth.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "s_user")
public class User{

	@Id
	private String Id;

	@Column(name = "user_name", nullable = false, length = 20, unique = true)
	private String userName;

	@Column(name = "password", nullable = false, length = 64)
	private String password;
	
	@Column(name = "first_name", length = 64)
	private String firstName;
	
	@Column(name = "last_name", length = 64)
	private String lastName;

	@Column(name = "email", length = 64)
	private String email;

	@OneToMany(fetch = FetchType.EAGER)
	private Set<Role> roles = new HashSet<Role>(0);//

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "mobile", length = 32)
	private String mobile;
	
	@Column(name = "dep_id", length = 64)
	private String departmentId;
	
	@Column(name = "oper_id", length = 64)
	private String operatorId;

	/**
	 * 1:locked， 0:unlocked
	 */
	@Column(name = "is_locked")
	private boolean isLocked;

	@Column(name = "is_available")
	private boolean isAvailable;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "update_time")
	private Date updateTime;

	public User() {
		
		this.isLocked = false;
		this.isAvailable = true;
        this.createTime = new Date();
        this.updateTime = this.createTime;
	}

	public User(String Id, String userName, String password, String firstName, String lastName, String email, String mobile) {
		this.Id = Id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.isLocked = false;
		this.isAvailable = true;
        this.createTime = new Date();
        this.updateTime = this.createTime;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
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

	public Set<Role> getRoles() {
		return roles;
	}
	
	

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "User")
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
