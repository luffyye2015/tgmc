package com.gmc.topic.web.vo;

import java.io.Serializable;

/**
 * Copyright(C)  GMC-TEST
 *
 * Module: 
 * @author  叶子丰
 * @version
 * @see
 * @since 2015-7-14
 * @description: 用户登录信息bean
 * @log:
 */
public class LoginUserVo implements Serializable{

	private static final long serialVersionUID = 8075783075767283918L;

	private Integer sid;
	
	private String userAccount;

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
	
	
}
