package com.bizs.manages.modle.serviceimpl.disruptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizs.common.resource.executor.DisruptorInit;
import com.bizs.manages.modle.service.disruptor.DisruptorService;
import com.bizs.manages.pojo.DisruptorEvent;
import com.bizs.manages.pojo.ProvideEvent;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
/**
 * 
 * @ClassName: DisruptorServiceImpl 
 * @Description: Disruptor的Service逻辑
 * @author: wjw
 * @param <E>
 * @date: 2017年1月24日 下午6:19:12
 */
@Service
public class DisruptorServiceImpl implements DisruptorService{

	@Autowired
	DisruptorInit disruptorInit;
	
	@Override
	public void provideEvent(Object obj) {
		
		Disruptor<DisruptorEvent> disruptor=disruptorInit.getDisruptor();
		
		// 发布事件
		RingBuffer<DisruptorEvent> ringBuffer =disruptor.getRingBuffer();
		
		long sequence = ringBuffer.next();//请求下一个事件序号；
		
		try {
			DisruptorEvent event = ringBuffer.get(sequence);//获取该序号对应的事件对象；
		    
			ProvideEvent provideEvent=new ProvideEvent();
			
			event.setDate(provideEvent);
		    
		} finally{
		    ringBuffer.publish(sequence);//发布事件；
		}
	}

	@Override
	public void customEvent() {
		
	}


}
