package com.bizs.common.dao;

import java.util.List;

public interface ParentDAO<E> {
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
}
