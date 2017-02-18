package com.bizs.common.service;

import java.util.List;

import com.bizs.common.dao.ParentDAO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class ServiceManage<E,DAO extends ParentDAO<E>> implements Services<E>{
	/**
	 * 注入的DAO
	 */
	protected DAO dao;
	
	public DAO getDao() {
		return dao;
	}
	
	public abstract void setDao(DAO dao);
	
	@Override
	public int insert(E e) {
		return dao.insert(e);
	}

	@Override
	public int update(E e) {
		return dao.update(e);
	}

	@Override
	public E selectOne(E e) {
		if(e==null)
			throw new NullPointerException();
		return dao.selectOne(e);
	}

	@Override
	public List<E> selectList(E e) {
		return dao.selectList(e);
	}

	@Override
	public int delete(E e) {
		return dao.delete(e);
	}

	@Override
	public int deletes(E e) {
		return dao.deletes(e);
	}
	
	/**
	 * 对selectList方法进行分页查询
	 * 
	 * @param e 要查询的数据对应的实体对象
	 * @param pageNum 查询第几页
	 * @param pageSize 每页显示的记录条数
	 * @return 符合查询条件的实体对象集合
	 */
	public PageInfo<E> selectListPage(E e, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List list = dao.selectList(e);
		PageInfo<E> pageInfo = new PageInfo(list);
		return pageInfo;
	}
}
