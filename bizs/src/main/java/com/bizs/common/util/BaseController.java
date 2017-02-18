package com.bizs.common.util;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bizs.common.service.Services;
import com.bizs.common.util.parsedata.ParseDataUtils;
import com.github.pagehelper.PageInfo;

public abstract class BaseController<E> implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 版本ID
	 */
	private static final long serialVersionUID = -2431851200121658667L;
	
	/**
	 * 
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
	/**
	 * 
	 * @return 返回
	 */
	public abstract Services<E> getService();
	
	/**
	 * 
	 * @Title: loadDate
	 * @Description: 数据函数返回处理参数
	 * @param request
	 * @param e
	 *            传参
	 * @return
	 * @return: E
	 */
	@RequestMapping("loadData")
	@ResponseBody
	public PageInfo loadData(HttpServletRequest request, E e) {
		// 页码
		String page = request.getParameter("page");
		// 每一页条数
		String rows = request.getParameter("rows");
		logger.debug("page:" + page + ",rows:= " + rows);
		int pageNum = 0;
		int pageSize = 0;
		try {
			pageNum = Integer.parseInt(page);
			pageSize = Integer.parseInt(rows);
		} catch (Exception ex) {
			pageNum = 1;
			pageSize = PageConstant.PAGE_SIZE;
		}
		PageInfo pager = getService().selectListPage(e, pageNum, pageSize);
		return pager;
	}

}
