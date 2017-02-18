package com.chinanet.manages.modle.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bizs.common.service.Services;
import com.bizs.common.util.BaseController;
import com.bizs.common.util.map.MapBaseUtil;
import com.chinanet.manages.common.realm.UsernamePasswordUsertypeToken;

/**
 * 
 * @ClassName: LoginController 
 * @Description:登录模块
 * @author: wjw
 * @date: 2017年1月23日 上午10:51:23
 */
@Controller
@RequestMapping(value="login")
public class LoginController extends BaseController{
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 版本ID
	 */
	private static final long serialVersionUID = -747733473093833171L;
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 管理系统的登录请求
	 * @param request
	 * @return: String
	 */
	@RequestMapping(value="login")
	@ResponseBody
	public Map login(HttpServletRequest request,String name,String password){
		
		Subject subject=SecurityUtils.getSubject();
		
		MapBaseUtil mapBase=new MapBaseUtil();
		
		Map<Object ,Object> map=new HashMap<Object ,Object>();
		
		//自己封装的token
		UsernamePasswordUsertypeToken token=new UsernamePasswordUsertypeToken(name,password,"admin");
		
		try {
			subject.login(token);
			map.put("obj", "登录成功");
			mapBase.PutMap(0, map);
		} catch (Exception e) {
			map.put("obj", "账号或者密码错误,请重新输入");
			mapBase.PutMap(1, map);
		}
		
		return mapBase.getMap();
	}
	
	/**
	 * 
	 * @Title: loginWX 
	 * @Description: 微信端主入口
	 * @return: void
	 */
	public void loginWX(){
		
		
	}
	
	/**
	 * 
	 * @Title: exsitSystem 
	 * @Description: 退 出 后台系统
	 * @return: void
	 */
	@RequestMapping(value="logout")
	public void exsitSystem(){
		Subject subject=SecurityUtils.getSubject();
		subject.logout();
	}

	@Override
	public Services getService() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
