package com.chinanet.manages.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bizs.manages.modle.service.user.PermissionService;
import com.bizs.manages.pojo.PermissionEntity;

/**
 * 
 * @ClassName: SpringMVCFilterInterceptor
 * @Description: MVC拦截(主要作用 为了菜单栏服务)
 * @author: wjw
 * @date: 2017年2月17日 下午3:24:48
 */
public class SpringMVCFilterInterceptor implements HandlerInterceptor {

	@Autowired
	PermissionService permissionService;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse respsonse, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	/**
	 * 展开属性 和面包屑
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String id = request.getParameter("id");
		//实体类
		PermissionEntity permissionEntity = null;
		
		if (id.equals("") || id == null) {
			//跳转到首页
			request.getRequestDispatcher("/jspview/user/user.jsp").forward(request, response);
		}else{
			PermissionEntity e=new PermissionEntity();
			e.setId(id);
			try {
				permissionEntity=permissionService.selectOne(e);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			//保存到session中
			request.getSession().setAttribute("PermissionEntity", permissionEntity);
		}
		return true;
	}

}
