package com.bizs.common.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

public interface Services <E extends Object> {
	/**
	 * insert
	 * @param e
	 * @return
	 */
	int insert(E e);
	/**
	 * update 
	 * @param e
	 * @return
	 */
	int update(E e);
	/**
	 * select
	 * @param e
	 * @return
	*/
	E   selectOne(E e);
	/**
	 * selectList
	 * @param e
	 * @return
	 */
	List<E> selectList(E e);
	/**
	 * delete
	 * @param e
	 * @return
	 */
	int delete(E e);
	/**
	 * deletes
	 * @param e
	 * @return
	 */
	int deletes(E e);
	
	/**
	 * 分页查询
	 * 
	 * @param e 参数
	 * @return tag
	 */
	public PageInfo selectListPage(E e,int pageNum,int pageSize);
	
}
