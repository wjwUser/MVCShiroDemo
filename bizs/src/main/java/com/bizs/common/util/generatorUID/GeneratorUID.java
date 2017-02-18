package com.bizs.common.util.generatorUID;

import java.util.UUID;

/**
 * 
 * @ClassName: GeneratorUID 
 * @Description: UID生成类
 * @author: wjw
 * @date: 2017年1月27日 下午1:52:15
 */
public class GeneratorUID {
	
	/**
	 * 
	 * @Title: createUUID 
	 * @Description: 生成UUID的方法
	 * @return
	 * @return: String
	 */
	public static String createUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}
}
