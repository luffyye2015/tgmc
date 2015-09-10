package com.gmc.topic.web.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

import com.google.gson.Gson;

/***
 * 
 * Copyright(C)  GMC-TEST
 *
 * Module: 笔试题
 * @author  叶子丰
 * @version
 * @see
 * @since 2015-7-14
 * @description: 基类控制器，会封装一些公用的方法给子类使用
 * @log:
 */
@Controller
public class BaseController {

	protected Logger log = LoggerFactory.getLogger(this.getClass()); 
    
}
