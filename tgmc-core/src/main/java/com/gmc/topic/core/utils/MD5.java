package com.gmc.topic.core.utils;

/**
 * Copyright(C) 
 *
 * Module: 
 * @author 叶子丰
 * @version
 * @see
 * @since 2013-10-31
 * @description: MD5加密类
 * @log:
 */
public class MD5 {

	private static final MD5 instance = new MD5();
	/**
	 * @todo Returns a new String of MD5 for input String.
	 * @return MD5
	 */
	public static MD5 getInstance() {
		return instance;
	}

	public synchronized String getMD5(String str) {
		return StringUtils.hash(str);
	}
	
	
	
	public static void main(String args[]) {
		MD5 md5 = getInstance(); 
		System.out.println("MD5(\"11111111\"):" + md5.getMD5("11111111"));
	}
}
