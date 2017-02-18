package com.chinanet.manages.modle.provide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bizs.common.service.Services;
import com.bizs.common.util.BaseController;
import com.bizs.manages.modle.service.disruptor.DisruptorService;
/**
 * 
 * @ClassName: DisruptorController 
 * @Description: 用来处理Disruptor的控制
 * @author: wjw
 * @date: 2017年1月24日 下午6:15:51
 */
@Controller
@RequestMapping(value="disruptor")
public class DisruptorController extends BaseController<Object>{
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 版本ID
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	DisruptorService disruptorService;
	
	/**
	 * 
	 * @Title: provideEvent 
	 * @Description: 发布事件
	 * @return: void
	 */
	@RequestMapping(value="provide")
	public String provideEvent(){
		
		disruptorService.provideEvent("");
		return "index";
	}

	@Override
	public Services<Object> getService() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
