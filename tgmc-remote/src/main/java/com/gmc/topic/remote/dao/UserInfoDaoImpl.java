package com.gmc.topic.remote.dao;


import org.springframework.stereotype.Repository;

import com.gmc.topic.core.dao.MyBatisDao;


/**
 * Copyright(C)  GMC-TEST
 *
 * Module: 笔试题
 * @author  叶子丰
 * @version
 * @see
 * @since 2015-7-13
 * @description: UserInfoDao接口实现
 * @see UserInfoDao
 * @log:
 */
@Repository
public class UserInfoDaoImpl extends MyBatisDao implements UserInfoDao{

	@Override
	public void saveOne(String key, Object object) throws Exception{
		getSqlSession().insert(key, object);
	}

	@Override
	public void updateOne(String key, Object object) throws Exception{
		getSqlSession().update(key, object);
	}

	@Override
	public <T> T getOne(String key, Object params) throws Exception{
		return getSqlSession().selectOne(key, params);
	}

	@Override
	public <T> T getOneById(String key, Object params) throws Exception {
		return getSqlSession().selectOne(key, params);
	}

}
