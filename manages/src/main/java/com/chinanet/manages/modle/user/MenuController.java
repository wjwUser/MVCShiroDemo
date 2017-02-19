package com.chinanet.manages.modle.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bizs.common.service.Services;
import com.bizs.common.util.BaseController;
import com.bizs.common.util.map.MapBaseUtil;
import com.bizs.manages.modle.service.user.PermissionService;
import com.bizs.manages.pojo.MenuPOJO;
import com.bizs.manages.pojo.PermissionEntity;
import com.bizs.manages.pojo.UserEntity;

/**
 * 
 * @ClassName: MenuController
 * @Description: 菜单控制类
 * @author: wjw
 * @date: 2017年1月28日 上午12:51:02
 */
@Controller
@RequestMapping(value = "menu")
public class MenuController extends BaseController {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 版本ID
	 */
	private static final long serialVersionUID = 5500120009623315499L;

	@Autowired
	PermissionService permissionService;

	/**
	 * 
	 * @Title: viewMenu
	 * @Description: 菜单显示类
	 * @return: void
	 */
	@RequestMapping(value = "view")
	@ResponseBody
	public String viewMenu(HttpServletRequest request) {
		String json = permissionService.selectMenu(request);
		return json;
	}

	/**
	 * 
	 * @Title: MenuControl
	 * @Description: 用来控制页面跳转
	 * @param request
	 * @param e
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "control")
	public String MenuControl(HttpServletRequest request, HttpServletResponse respsonse,
			@ModelAttribute("e") PermissionEntity e) {
		String url = null;
		try {
			if (e.getId() != null && e.getId() != "") {
				PermissionEntity permissionEntity = permissionService.selectOne(e);
				url = permissionEntity.getUrl();
				url = url.replace("/manages/", "/");
			} else {
				// 跳转到首页
				url = "jspview/index.jsp";
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return "forward:" + url;
	}

	/**
	 * 
	 * @Title: getBranchCrumb
	 * @Description: 面包屑展示
	 * @param request
	 * @param respsonse
	 * @param e
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "createbranch")
	@ResponseBody
	public Map getBranchCrumb(HttpServletRequest request, HttpServletResponse respsonse,
			@ModelAttribute("e") PermissionEntity e) {
		
		MapBaseUtil mapBase=new MapBaseUtil();
		
		Map<Object ,Object> map=new HashMap<Object ,Object>();
		
		if (e.getId() == null || e.getId().equals("")) {
			// 返回首页的地址
		} else {
			try {
				PermissionEntity permissionEntity = permissionService.selectOne(e);
				map.put("obj", permissionEntity);
				mapBase.PutMap(0, map);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return mapBase.getMap();
	}

	@Override
	public Services getService() {
		// TODO Auto-generated method stub
		return null;
	}

}
