package com.gmc.topic.api;

import com.gmc.topic.api.mapper.UserInfo;

/**
 * Copyright(C)  GMC-TEST
 *
 * Module: 笔试题
 * @author  叶子丰
 * @version
 * @see
 * @since 2015-7-13
 * @description: 用户信息接口
 * @log:
 */
public interface UserInfoService {

	/****
	 * 
	 * @description: 保存一条记录
	 * @param user
	 */
	void saveOne(UserInfo user) throws Exception;
	
	/****
	 * 
	 * @description: 通过主键查询一条记录
	 * @param sid
	 * @return
	 * @throws Exception
	 */
	UserInfo getOne(Integer sid) throws Exception;
	
	/***
	 * 
	 * @description: 通过用户名查询一条记录
	 * @param account
	 * @return
	 * @throws Exception
	 */
	UserInfo getOneByAccount(String account) throws Exception;
	
	/***
	 * 
	 * @description: 修改一条记录
	 * @param user
	 * @throws Exception
	 */
	void updateOne(UserInfo user) throws Exception;
}
