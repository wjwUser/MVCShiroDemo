package com.chinanet.manages.modle.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bizs.common.service.Services;
import com.bizs.common.util.BaseController;
import com.bizs.common.util.map.MapBaseUtil;
import com.bizs.manages.modle.service.user.UserService;
import com.bizs.manages.pojo.UserEntity;

@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController<UserEntity> {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 版本ID
	 */
	private static final long serialVersionUID = 8198132227739432911L;

	@Autowired
	UserService userService;
	
	@RequestMapping(value="login")
	public String Login(){
		
		return "jspview/user/user";
	}
	
	/**
	 * 
	 * @Title: UserLogin
	 * @Description: 用户列表查询
	 * @param request
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "user")
	@ResponseBody
	public String UserLogin(HttpServletRequest request,@ModelAttribute("e") UserEntity e ) {
		String jsonString = JSON.toJSONString(super.loadData(request, e));
		return jsonString;
	}

	@Override
	public Services<UserEntity> getService() {
		return userService;
	}

}
