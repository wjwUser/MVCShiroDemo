package com.bizs.manages.modle.serviceimpl.user;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bizs.common.service.ServiceManage;
import com.bizs.common.util.tree.ZTreeUtils;
import com.bizs.manages.dao.user.PermissionDAO;
import com.bizs.manages.modle.service.user.PermissionService;
import com.bizs.manages.pojo.PermissionEntity;
/**
 * 
 * @ClassName: PermissionServiceImpl 
 * @Description: 权限业务层
 * @author: wjw
 * @date: 2017年2月19日 上午11:26:17
 */
@Service
public class PermissionServiceImpl extends ServiceManage<PermissionEntity,PermissionDAO> implements PermissionService{
	
	
	@Resource(name="permissionDAO")
	@Override
	public void setDao(PermissionDAO dao) {
		this.dao=dao;
	}
	
	/**
	 * 构建Ztree的菜单导航栏
	 */
	public String selectMenu(HttpServletRequest request) {
		PermissionEntity permissionEntity=new PermissionEntity();
		permissionEntity.setType("1");
		
		List listPermissionEntity=dao.selectList(permissionEntity);
		String menuString=ZTreeUtils.createZtree(listPermissionEntity);
		
		return menuString;
	}
	
	

}
