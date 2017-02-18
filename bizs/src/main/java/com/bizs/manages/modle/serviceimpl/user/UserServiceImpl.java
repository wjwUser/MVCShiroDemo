package com.bizs.manages.modle.serviceimpl.user;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizs.common.service.ServiceManage;
import com.bizs.manages.dao.user.UserDAO;
import com.bizs.manages.modle.service.user.UserService;
import com.bizs.manages.pojo.UserEntity;

@Service(value="userService")
public class UserServiceImpl extends ServiceManage<UserEntity,UserDAO> implements UserService{
	
	
	@Override
	@Resource(name="userDAO")
	public void setDao(UserDAO userDao) {
		this.dao=userDao;
	}
	
	
	
}
