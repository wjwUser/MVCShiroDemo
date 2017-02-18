package com.bizs.common.resource.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.bizs.common.disruptor.FactoryEvent;
import com.bizs.common.handler.disruptor.DisruptorEventHandler;
import com.bizs.manages.pojo.DisruptorEvent;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

@Component
public class DisruptorInit implements InitializingBean {

	/**
	 * disruptor---Thread
	 */
	public Disruptor<DisruptorEvent> disruptor;
	/**
	 * 线程池
	 */
	ExecutorService executor;
	/**
	 * ringBuffer的大小
	 */
	int ringBufferSize; // RingBuffer 大小，必须是 2 的 N 次方;
	
	/**
	 * 
	 * @Title: getDisruptor 
	 * @Description: Disruptor暴露方法
	 * @return Disruptor<DisruptorEvent>
	 */
	public Disruptor<DisruptorEvent> getDisruptor(){
		return disruptor;
	}
	
	/**
	 * 
	 * @Title: getExecutorService 
	 * @Description: Executor暴露方法
	 * @return ExecutorService
	 */
	public ExecutorService getExecutorService(){
		return executor;
	}
	
	/**
	 * 
	 * @Title: init 
	 * @Description: disruptor初始化
	 * @return: Disruptor<DisruptorEvent>
	 */
	private Disruptor<DisruptorEvent> init() {
		EventFactory<DisruptorEvent> eventFactory = new FactoryEvent();

		executor = Executors.newSingleThreadExecutor();

		ringBufferSize = 1024 * 1024;

		this.disruptor = new Disruptor<DisruptorEvent>(eventFactory, ringBufferSize, executor, ProducerType.SINGLE,
				new YieldingWaitStrategy());
		
		DisruptorEventHandler<DisruptorEvent> disruptorEventHandler = new DisruptorEventHandler();
		disruptor.handleEventsWith(disruptorEventHandler);
		
		return disruptor;
	}
	/**
	 * bean初始化后执行函数
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		init();
		this.disruptor.start();
	}

}
