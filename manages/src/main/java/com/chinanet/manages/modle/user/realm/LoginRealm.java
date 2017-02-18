package com.chinanet.manages.modle.user.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bizs.manages.modle.service.user.UserService;
import com.bizs.manages.pojo.UserEntity;
/**
 * 
 * @ClassName: LoginRealm 
 * @Description: 前台登录Realm
 * @author: wjw
 * @date: 2017年1月23日 下午3:47:35
 */
@Component
public class LoginRealm extends AuthorizingRealm implements Realm{
	
	@Autowired
	UserService userService;
	
	/**
	 * Realm的名字
	 */
	@Override
	public String getName() {
		String name="LoginRealm";
		return name;
	}
	/**
	 * 是否支持
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		
		return true;
	}
	/**
	 * 权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalcollection) {
		
		return null;
	}
	/**
	 * 身份认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationtoken)
			throws AuthenticationException {
		
		//subject
		Subject subject=SecurityUtils.getSubject();
		
		//session
		Session session=subject.getSession();
		
		//token
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationtoken;
		
		String username = (String) token.getPrincipal(); // 得到用户名
		String password = new String((char[]) token.getCredentials()); // 得到密码
		
		UserEntity userEntity=new UserEntity();
		//Init-start
		userEntity.setName(username);
		userEntity.setPassword(password);
		//Init-end
		try {
			UserEntity returnUserEntity=userService.selectOne(userEntity);
			if(returnUserEntity==null){
				throw new ShiroException();
			}
			session.setAttribute("UserEntity", returnUserEntity);
		} catch (Exception e) {
			throw new ShiroException();
		}
		
		return new SimpleAuthenticationInfo(username,password,getName());
	}
	
	
	
	

}
