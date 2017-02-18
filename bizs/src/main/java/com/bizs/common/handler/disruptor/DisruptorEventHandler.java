package com.bizs.common.handler.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * 
 * @ClassName: DisruptorEventHandler 
 * @Description: DisruptorEvent的Handler
 * @author: wjw
 * @param <E>
 * @date: 2017年1月25日 上午10:23:03
 */
public class DisruptorEventHandler<E> implements EventHandler<E>{

	@Override
	public void onEvent(E event, long sequence, boolean endOfBatch) throws Exception {
		/**
		 * instanceof比较事件类型
		 */
		System.out.println("Event: " + event);
	}


}
