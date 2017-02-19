package com.bizs.common.util.tree;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.omg.CORBA.Request;

import com.alibaba.fastjson.JSONArray;
import com.bizs.manages.pojo.MenuPOJO;

/**
 * 
 * @ClassName: ZTreeUtils 
 * @Description: Ztree工具类
 * @author: wjw
 * @date: 2017年2月8日 上午10:38:07
 */
public class ZTreeUtils {
	
	private static String contextURI="/manages";
	
	private static List<Object> objectList = new ArrayList<Object>();
	
	/**
	 * 
	 * @Title: createZtree 
	 * @Description: 创建函数
	 * @return
	 * @return: String
	 */
	public static String createZtree(List<Object> list){
		JSONArray json = new JSONArray();
		objectList=list;
		MenuPOJO ZtreeModel = new MenuPOJO();
		ZtreeModel.setName("Start");
		ZtreeModel.setId("0");
        List<MenuPOJO> listTreeModel = getObjectResult("0");
        getChildrenNode(listTreeModel);
        ZtreeModel.setChildren(listTreeModel);
        json.add(ZtreeModel);
		return json.toJSONString();
	} 
	
	/**
	 * 
	 * @Title: GetResult 
	 * @Description: 获取函数
	 * @return
	 * @return: List<MenuPOJO>
	 */
	public static List<MenuPOJO> getObjectResult(String pid){
		
		List<MenuPOJO> ZtreeModel=new ArrayList<MenuPOJO>();
		
		try {
			for(Object o:objectList){
				Method methodPid=o.getClass().getMethod("getPid", new Class[]{});
				Object objectPid=methodPid.invoke(o, new Object[]{});
				if(objectPid.equals(pid)){
					ZtreeModel.add(parseZtreeModel(o));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ZtreeModel;
	}
	
	/**
	 * 
	 * @Title: parseZtreeModel 
	 * @Description: 参数 : 转换函数
	 * @return
	 * @return: MenuPOJO
	 */
	public static MenuPOJO parseZtreeModel(Object o){
		MenuPOJO menuPOJO=new MenuPOJO();
		try {
			Method methodName=o.getClass().getMethod("getName", new Class[]{});
			Object name=methodName.invoke(o, new Object[]{});
			Method methodId=o.getClass().getMethod("getId", new Class[]{});
			Object id=methodId.invoke(o, new Object[]{});
			Method methodURL=o.getClass().getMethod("getUrl", new Class[]{});
			Object url=methodURL.invoke(o, new Object[]{});
			menuPOJO.setId(id.toString());
			menuPOJO.setName(name.toString());
			menuPOJO.setUrl(url.toString());
			menuPOJO.setTarget("_self");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("error---ZtreeUtils---error");
		}
		return menuPOJO;
	}
	
	/**
	 * 
	 * @Title: getChildrenNode 
	 * @Description: 递归获取子节点函数
	 * @param listMenuPOJO
	 * @return: void
	 */
	public static void getChildrenNode(List<MenuPOJO> listMenuPOJO){
		for (MenuPOJO MenuPOJOModel : listMenuPOJO) {
            List<MenuPOJO> listChildrenNode = getObjectResult(MenuPOJOModel.getId());
            if (listChildrenNode.size() > 0) {
            	MenuPOJOModel.setChildren(listChildrenNode);
                getChildrenNode(listChildrenNode);
            }else{
                
            }
        }
	}
	/**
	 * 
	 * @Title: removeChildrenNode 
	 * @Description: 删除节点函数
	 * @param listMenuPOJO
	 * @return: void
	 */
	public static void removeChildrenNode(List<MenuPOJO> listMenuPOJO){
		
	}
	
}
