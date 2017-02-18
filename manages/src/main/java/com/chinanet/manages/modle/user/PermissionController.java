package com.chinanet.manages.modle.user;

import org.springframework.stereotype.Controller;

import com.bizs.common.service.Services;
import com.bizs.common.util.BaseController;
import com.bizs.manages.pojo.PermissionEntity;

/**
 * 
 * @ClassName: PermissionController 
 * @Description: 权限控制
 * @author: wjw
 * @date: 2017年1月25日 下午5:50:20
 */
@Controller
public class PermissionController extends BaseController<PermissionEntity>{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 版本ID
	 */
	private static final long serialVersionUID = 1066771700234066876L;

	@Override
	public Services<PermissionEntity> getService() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
