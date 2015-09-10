package com.gmc.topic.remote.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright(C)  GMC-TEST
 *
 * Module: 笔试题
 * @author  叶子丰
 * @version
 * @see
 * @since 2015-7-13
 * @description: 用户信息表数据模型
 * @log:
 */
public interface UserInfoDao {

    void saveOne(String key,Object object) throws Exception;
	
	void updateOne(String key,Object object) throws Exception;
	
	<T> T getOneById(String key, Object params) throws Exception;
	
	<T> T getOne(String key, Object params) throws Exception;
}
