package com.chinanet.manages.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bizs.manages.pojo.PermissionEntity;

public class SpringAllInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		HttpSession session = request.getSession();

		// 菜单展开
		PermissionEntity permissionEntity = (PermissionEntity) session.getAttribute("PermissionEntity");
		if (permissionEntity != null) {
			request.setAttribute("menuId", permissionEntity.getPid());
		}
		
		return true;
	}

}
