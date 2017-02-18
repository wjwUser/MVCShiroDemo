package com.bizs.manages.modle.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bizs.common.service.Services;
import com.bizs.manages.pojo.MenuPOJO;
import com.bizs.manages.pojo.PermissionEntity;
import com.bizs.manages.pojo.UserEntity;

public interface PermissionService extends Services<PermissionEntity>{
	/**
	 * 
	 * @Title: selectMenu 
	 * @Description: 菜单显示
	 * @return
	 * @return: MenuPOJO
	 */
	String selectMenu(HttpServletRequest request);

}
