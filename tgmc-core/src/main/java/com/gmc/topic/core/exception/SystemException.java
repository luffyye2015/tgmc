package com.gmc.topic.core.exception;

/**
 * Copyright(C)  广州天源迪科信息技术有限公司
 *
 * Module: 东南亚电信项目
 * @author  叶子丰
 * @version
 * @see
 * @since 2014-11-20
 * @description: 系统类异常父类
 * @log:
 */
public class SystemException extends RuntimeException{

	private static final long serialVersionUID = 6317082256217115812L;

	 public SystemException() {  
		 
	 }  
	  	
	 public SystemException(String message) {  
	     super(message);   
	 }  
	  
	 public SystemException(Throwable cause) {  
	     super(cause);  
	 }  
	  
	 public SystemException(String message, Throwable cause) {  
	     super(message, cause);    
	 }  
}
