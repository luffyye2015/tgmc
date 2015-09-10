package com.gmc.topic.remote.service;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gmc.topic.api.UserInfoService;
import com.gmc.topic.api.mapper.UserInfo;
import com.gmc.topic.core.utils.MD5;
import com.gmc.topic.remote.BaseSimpleTest;

/**
 * Copyright(C)  GMC-TEST
 *
 * Module: 
 * @author  叶子丰
 * @version
 * @see
 * @since 2015-7-14
 * @description: 测试类
 * @log:
 */
public class UserInfoServiceImplTest extends BaseSimpleTest{

	@Autowired
	private UserInfoService userInfoService;
	
	@Test
	public void testSaveOne() throws Exception{
		UserInfo user=new UserInfo();
		user.setUserAccount("test1");
		user.setPassword(MD5.getInstance().getMD5("098765"));
		user.setEmail("test1@test.com");
		user.setType("1,2");
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		
		this.userInfoService.saveOne(user);
	}
	
	@Test
	public void testUpdateOne() throws Exception{
		Integer sid=1;
		UserInfo user=this.userInfoService.getOne(sid);
		assertNotNull(user);
		log.info("thie user is : {}",user);
		user.setType("1");
		this.userInfoService.updateOne(user);
	}
	
	@Test
	public void testGetOneByAccount() throws Exception{
		String account="test1";
		UserInfo user=this.userInfoService.getOneByAccount(account);
		assertNotNull(user);
		log.info("thie user is : {}",user);
	}
}
