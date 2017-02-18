package com.bizs.common.util.parsedata;

import com.alibaba.fastjson.JSON;
/**
 * 
 * @ClassName: ParseDataUtils 
 * @Description: 数据类型转换工具
 * @author: wjw
 * @param <E>
 * @date: 2017年2月15日 下午5:19:39
 */
public class ParseDataUtils<E> {
	/**
	 * 传参
	 */
	private E e;
	
	public ParseDataUtils(E e){
		this.e=e;
	}
	/**
	 * 
	 * @Title: compareData 
	 * @Description: TODO
	 * @param e
	 * @return e为空时返回 解析好的全局参数数据
	 * @return: String 传参不为空时 返回解析好的参数类型
	 */
	public String compareData(E e){
		if(e==null)
			return JSON.toJSONString(this.e);
		return  JSON.toJSONString(e);
	}
	
}
