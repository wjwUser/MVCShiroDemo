package com.bizs.manages.pojo;
/**
 * 
 * @ClassName: DisruptorEvent 
 * @Description: 所有事件的父类
 * @author: wjw
 * @date: 2017年1月24日 下午4:58:05
 */
public class DisruptorEvent {
	private String name;
	private String type;
	private CommandDate date;
	
	public CommandDate getDate() {
		return date;
	}
	public void setDate(CommandDate date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
