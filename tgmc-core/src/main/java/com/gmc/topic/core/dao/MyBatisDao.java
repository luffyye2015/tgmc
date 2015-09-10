package com.gmc.topic.core.dao;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/****
 * 
 * Copyright(C)  广州天源迪科信息技术有限公司
 *
 * Module: 东南亚电信项目
 * @author  叶子丰
 * @version
 * @see
 * @since 2014-11-10
 * @description: MyBatis的Dao基类
 * @log:
 */
public class MyBatisDao extends SqlSessionDaoSupport{
	
	public void save(String key, Object object) {
		getSqlSession().insert(key, object);
	}
	
	public void delete(String key, Serializable id) {
		getSqlSession().delete(key, id);
	}

	public void delete(String key, Object object) {
		getSqlSession().delete(key, object);
	}
	
	public <T> T get(String key, Object params) {
		return (T) getSqlSession().selectOne(key, params);
	}
	
	public <T> List<T> getList(String key) {
		return getSqlSession().selectList(key);
	}
	
	public <T> List<T> getList(String key, Object params) {
		return getSqlSession().selectList(key, params);
	}
}
