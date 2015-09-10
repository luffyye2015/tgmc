package com.gmc.topic.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gmc.topic.api.UserInfoService;
import com.gmc.topic.api.mapper.UserInfo;
import com.gmc.topic.core.exception.BusinessException;
import com.gmc.topic.core.utils.MD5;
import com.gmc.topic.web.enums.Types;
import com.gmc.topic.web.vo.LoginUserVo;

/**
 * Copyright(C)  GMC-TEST
 *
 * Module: 
 * @author  叶子丰
 * @version
 * @see
 * @since 2015-7-14
 * @description: 用户Controller
 * @log:
 */
@Controller
@RequestMapping("/user/info")
public class UserController extends BaseController{

	@Autowired
	private UserInfoService userInfoService;
	
	/****
	 * 
	 * @description: 查询用户信息
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/query")
	public String query(HttpServletRequest request,ModelMap model) throws Exception{
		LoginUserVo vo=(LoginUserVo)request.getSession().getAttribute("loginUser");
		//如果用户没登录，跳转到登录页面
		if(vo==null){
			return "redirect:/login";
		}
		Integer sid=vo.getSid();
		UserInfo user=this.userInfoService.getOne(sid);
		if(user==null){
			throw new Exception("用户不存在");
		}
		String type=user.getType();
		if(StringUtils.isNotBlank(type)){
			String[] types=type.split(",");
			model.addAttribute("types", types);
		}
		
		model.addAttribute("typeList", Types.values());
		model.addAttribute("user", user);
		
		return "base/info";
	}
	
	/***
	 * 
	 * @description: 更新用户信息
	 * @param userAccount
	 * @param pwd
	 * @param email
	 * @param type
	 * @return
	 * @throws BusinessException
	 * @throws Exception
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(@RequestParam(value="sid",required=false) Integer sid,@RequestParam(value="userAccount",required=false) String userAccount,@RequestParam(value="pwd",required=false) String pwd,
			@RequestParam(value="email",required=false) String email,@RequestParam(value="types[]",required=false) String[] types) throws BusinessException,Exception{
		Map<String, Object> map=new HashMap<String, Object>();
		if(sid==null){
			throw new Exception("系统异常");
		}
		if(StringUtils.isBlank(userAccount)){
			throw new Exception("请填写用户名");
		}		
		
		try{
			UserInfo user=this.userInfoService.getOne(sid);
			//如果修改了用户名需查询用户名是否已存在
			if(!userAccount.equals(user.getUserAccount())){
				UserInfo u=this.userInfoService.getOneByAccount(userAccount);
				if(u!=null){
					throw new BusinessException("用户名已存在");
				}
			}
			StringBuilder type=new StringBuilder();
			if(types!=null){
				for(int i=0;i<types.length;i++){
					type.append(types[i]);
					if(i<types.length-1){
						type.append(",");
					}
				}
			}
			user.setUserAccount(userAccount);
			if(StringUtils.isNotBlank(pwd)) user.setPassword(MD5.getInstance().getMD5(pwd));
			user.setEmail(email);
			user.setType(type.toString());
			//执行修改操作
			this.userInfoService.updateOne(user);
		}catch(BusinessException e){
			throw new BusinessException(e.getMessage());
		}catch(Exception e){
			log.error(">>>>>>>>>>修改用户信息异常<<<<<<<<<",e);
			throw new Exception("系统繁忙，稍后请重试");
		}
		
		map.put("flag", true);		
		map.put("msg", "修改用户信息成功");		
		return map;
	}
}
