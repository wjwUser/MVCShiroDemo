package com.bizs.common.disruptor;

import com.bizs.manages.pojo.DisruptorEvent;
import com.lmax.disruptor.EventFactory;
/**
 * 
 * @ClassName: FactoryEvent 
 * @Description: FactoryEvent 事件实例化工厂
 * @author: wjw
 * @date: 2017年1月24日 下午3:49:43 
 * @param <E>
 */
public class FactoryEvent implements EventFactory<DisruptorEvent> {
	
	@Override
	public DisruptorEvent newInstance() {
		return new DisruptorEvent();
	}
}
