package com.gmc.topic.web.enums;

/**
 * Copyright(C)  GMC-TEST
 *
 * Module: 
 * @author  叶子丰
 * @version
 * @see
 * @since 2015-7-14
 * @description: 行业枚举类
 * @log:
 */
public enum Types {

	DENGSI("1","灯饰"),FUZHUANG("2","服装"),WANJU("3","玩具");
	
	private String code;
	
	private String desc;
	
	private Types(String code,String desc){
		this.code=code;
		this.desc=desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
