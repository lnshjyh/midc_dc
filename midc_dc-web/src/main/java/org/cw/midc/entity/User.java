package org.cw.midc.entity;

import org.cw.midc.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class User extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 3428451338994126059L;

	private String userId;
    
    private String account;
    
    private String trueName;
    
    private String password;
    
    private Date birth;
    
    private String sex;
    
    private String email;
    
    private String mobile;
    
    private Integer errorCount;
    
    private Boolean isLock;
    
    private Date loginTime;
    
    private String loginIp;
    
    private Integer isDelete;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String remark;

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUserId( ) {
		return userId;
	}

	public void setUserId( String userId ) {
		this.userId = userId;
	}

	public String getAccount( ) {
		return account;
	}

	public void setAccount( String account ) {
		this.account = account;
	}

	public String getTrueName( ) {
		return trueName;
	}

	public void setTrueName( String trueName ) {
		this.trueName = trueName;
	}

	public String getPassword( ) {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public Date getBirth( ) {
		return birth;
	}

	public void setBirth( Date birth ) {
		this.birth = birth;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail( ) {
		return email;
	}

	public void setEmail( String email ) {
		this.email = email;
	}

	public String getMobile( ) {
		return mobile;
	}

	public void setMobile( String mobile ) {
		this.mobile = mobile;
	}

	public Integer getErrorCount( ) {
		return errorCount;
	}

	public void setErrorCount( Integer errorCount ) {
		this.errorCount = errorCount;
	}
	public Boolean getIsLock( ) {
		return isLock;
	}

	public void setIsLock( Boolean isLock ) {
		this.isLock = isLock;
	}

	public Date getLoginTime( ) {
		return loginTime;
	}

	public void setLoginTime( Date loginTime ) {
		this.loginTime = loginTime;
	}

	public String getLoginIp( ) {
		return loginIp;
	}

	public void setLoginIp( String loginIp ) {
		this.loginIp = loginIp;
	}
}
