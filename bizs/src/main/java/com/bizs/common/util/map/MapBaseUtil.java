package com.bizs.common.util.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: MapBase
 * @Description: 关于AJAX中Map的封装
 * @author: wjw
 * @date: 2017年1月27日 下午1:56:56
 */
public class MapBaseUtil {

	private Map map;
	
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Map<Object, Object> getMapSecond() {
		return mapSecond;
	}

	public void setMapSecond(Map<Object, Object> mapSecond) {
		this.mapSecond = mapSecond;
	}

	// 操作层Map
	public Map<Object, Object> mapSecond;
	
	public MapBaseUtil() {
		this.map = new HashMap();
	}
	
	/**
	 * 
	 * @Title: InitMap 
	 * @Description: TODO
	 * @param status 0代表成功 1代表失败
	 */
	public static Map InitMap(int status,Map map) {
		if (status == 0) {
			map.put("status", "success");
		} else if (status == 1) {
			map.put("status", "error");
		} else {
			map.put("status", "Debug");
		}
		return map;
	}
	
	/**
	 * 
	 * @Title: PutMap 
	 * @Description: 放入元素信息
	 * @param status
	 * @param Getmap
	 * @return
	 * @return: Map<?,?>
	 */
	public Map<?, ?> PutMap(int status,Map Getmap){
		map=InitMap(status,map);
		map.put("obj", Getmap);
		return map;
	}
	
}
