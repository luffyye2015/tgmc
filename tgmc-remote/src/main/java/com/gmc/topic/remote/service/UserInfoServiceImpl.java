package com.gmc.topic.remote.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gmc.topic.api.UserInfoService;
import com.gmc.topic.api.mapper.UserInfo;
import com.gmc.topic.remote.dao.UserInfoDao;

/**
 * Copyright(C)  GMC-TEST
 *
 * Module: 笔试题
 * @author  叶子丰
 * @version
 * @see
 * @since 2015-7-13
 * @description: UserInfoService接口实现
 * @see UserInfoService
 * @log:
 */
public class UserInfoServiceImpl implements UserInfoService{
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public void saveOne(UserInfo user) throws Exception {
		//保存进数据库
		this.userInfoDao.saveOne("userInfoMapper.insert", user);
	}

	@Override
	public UserInfo getOne(Integer sid) throws Exception {
		UserInfo info=this.userInfoDao.getOneById("userInfoMapper.selectByPrimaryKey", sid);
		return info;
	}

	@Override
	public void updateOne(UserInfo user) throws Exception {
		//保存进数据库
		this.userInfoDao.updateOne("userInfoMapper.update", user);
	}

	@Override
	public UserInfo getOneByAccount(String account) throws Exception {
		UserInfo info=this.userInfoDao.getOne("userInfoMapper.selectByAccount", account);
		return info;
	}

}
