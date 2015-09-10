package com.gmc.topic.api.mapper;

import java.io.Serializable;
import java.util.Date;

/***
 * 
 * Copyright(C)  GMC-TEST
 *
 * Module: 笔试题
 * @author  叶子丰
 * @version
 * @see
 * @since 2015-7-13
 * @description: 用户信息实体类
 * @log:
 */
public class UserInfo implements Serializable{
	
	private static final long serialVersionUID = 3323265572011371352L;

	/**主键ID**/
	private Integer sid;
	
	/**用户账号，英文字母加数字**/
	private String userAccount;
	
	/**密码**/
	private String password;
	
	/**邮箱地址**/
	private String email;
	
	/**行业：灯饰/服装/玩具**/
	private String type;
	
	/**创建时间**/
	private Date createTime;
	
	/**上次登录时间**/
	private Date lastLoginTime;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	@Override
	public String toString() {
		return "UserInfo [sid=" + sid + ", userAccount=" + userAccount + ", password=" + password + ", email=" + email + ", type=" + type + ", createTime=" + createTime + ", lastLoginTime=" + lastLoginTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + ((userAccount == null) ? 0 : userAccount.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((lastLoginTime == null) ? 0 : lastLoginTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (userAccount == null) {
			if (other.userAccount != null)
				return false;
		} else if (!userAccount.equals(other.userAccount))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (lastLoginTime == null) {
			if (other.lastLoginTime != null)
				return false;
		} else if (!lastLoginTime.equals(other.lastLoginTime))
			return false;
		
		return true;
	}
}
