package com.chinanet.manages.modle.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bizs.common.service.Services;
import com.bizs.common.util.BaseController;
import com.bizs.manages.modle.service.user.RoleService;
import com.bizs.manages.pojo.RoleEntity;
/**
 * 
 * @ClassName: RoleController 
 * @Description: 角色控制层
 * @author: wjw
 * @date: 2017年2月19日 上午11:57:31
 */
@Controller
@RequestMapping(value="role")
public class RoleController extends BaseController<RoleEntity>{
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	RoleService roleService;
	
	@Override
	public Services<RoleEntity> getService() {
		return roleService;
	}
	
	@RequestMapping(value="login")
	public String Login(HttpServletRequest request){
		return "jspview/user/roleManager";
	}
	
	@RequestMapping(value = "role")
	@ResponseBody
	public String RoleLogin(HttpServletRequest request,@ModelAttribute("e") RoleEntity e ) {
		String jsonString = JSON.toJSONString(super.loadData(request, e));
		return jsonString;
	}
	
}
