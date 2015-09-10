package com.gmc.topic.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gmc.topic.api.UserInfoService;
import com.gmc.topic.api.mapper.UserInfo;
import com.gmc.topic.core.exception.BusinessException;
import com.gmc.topic.core.utils.MD5;
import com.gmc.topic.web.vo.LoginUserVo;

/**
 * Copyright(C)  GMC-TEST
 *
 * Module: 
 * @author  叶子丰
 * @version
 * @see
 * @since 2015-7-14
 * @description: 登录Controller
 * @log:
 */
@Controller
public class LoginController extends BaseController{

	@Autowired
	private UserInfoService userInfoService;
	
	/***
	 * 
	 * @description: 跳转到登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		log.info(">>>>>>>>>Now enter into login method<<<<<<<<<<<");
		log.info(">>>>>>>>>Now left login method<<<<<<<<<<<");
		return "hello";
	}
	
	/***
	 * 
	 * @description: 执行登录
	 * @param userAccount
	 * @param pwd
	 * @return
	 */
	@RequestMapping("/doLogin")
	@ResponseBody
	public Map<String, Object> doLogin(@RequestParam(value="userAccount",required=false) String userAccount,@RequestParam(value="pwd",required=false) String pwd,
			HttpServletRequest request) throws BusinessException,Exception{
		Map<String, Object> map=new HashMap<String, Object>();
		//1.校验用户名、密码
		if(StringUtils.isBlank(userAccount)){
			throw new Exception("请填写用户名");
		}
		if(StringUtils.isBlank(pwd)){
			throw new Exception("请输入登录密码");
		}
		UserInfo user=null;
		try{
			user=this.userInfoService.getOneByAccount(userAccount);
		}catch(Exception e){
			log.error(">>>>>>>>>>查询用户信息异常<<<<<<<<<",e);
			throw new BusinessException("系统繁忙，稍后请重试");
		}
		if(user==null){
			throw new BusinessException("用户不存在");
		}
		//校验用户密码
		if(!MD5.getInstance().getMD5(pwd).equals(user.getPassword())){
			throw new BusinessException("密码不正确");
		}
		//校验通过，保存登录会话信息
		LoginUserVo vo=new LoginUserVo();
		vo.setSid(user.getSid());
		vo.setUserAccount(user.getUserAccount());
		request.getSession().setAttribute("loginUser", vo);
		
		map.put("flag", true);		
		map.put("msg", "登录成功");		
		return map;
	}
}
