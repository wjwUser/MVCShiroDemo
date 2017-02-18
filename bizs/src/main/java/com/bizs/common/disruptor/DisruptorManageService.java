package com.bizs.common.disruptor;
/**
 * 
 * @ClassName: DisruptorManageService 
 * @Description: disruptor的服务提供
 * @author: wjw
 * @date: 2017年1月24日 下午3:37:42
 */
public interface DisruptorManageService{
	/**
	 * 
	 * @Title: provideEvent 
	 * @Description: 生产者提供事件
	 * @return: void
	 */
	public void provideEvent(Object event);
	/**
	 * 
	 * @Title: customEvent 
	 * @Description: 消费者消费事件
	 * @return: void
	 */
	public void customEvent();
}
