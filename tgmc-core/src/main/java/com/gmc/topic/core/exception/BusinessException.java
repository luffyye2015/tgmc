package com.gmc.topic.core.exception;

/**
 * Copyright(C)  广州天源迪科信息技术有限公司
 *
 * Module: 东南亚电信项目
 * @author  叶子丰
 * @version
 * @see
 * @since 2014-11-20
 * @description: 业务异常父类
 * @log:
 */
public class BusinessException extends Exception{

	private static final long serialVersionUID = 1216723439762832606L;

	public BusinessException() {  
        // TODO Auto-generated constructor stub  
    }  
  
    public BusinessException(String message) {  
        super(message);  
        // TODO Auto-generated constructor stub  
    }  
  
    public BusinessException(Throwable cause) {  
        super(cause);  
        // TODO Auto-generated constructor stub  
    }  
  
    public BusinessException(String message, Throwable cause) {  
        super(message, cause);  
        // TODO Auto-generated constructor stub  
    }  
}
