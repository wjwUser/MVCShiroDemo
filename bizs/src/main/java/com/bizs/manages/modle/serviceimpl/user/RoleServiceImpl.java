package com.bizs.manages.modle.serviceimpl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bizs.common.service.ServiceManage;
import com.bizs.manages.dao.user.RoleDAO;
import com.bizs.manages.modle.service.user.RoleService;
import com.bizs.manages.pojo.RoleEntity;

/**
 * 
 * @ClassName: RoleServiceImpl 
 * @Description: 角色的业务实现层
 * @author: wjw
 * @date: 2017年2月19日 上午11:24:24
 */
@Service
public class RoleServiceImpl extends ServiceManage<RoleEntity, RoleDAO>implements RoleService{

	@Resource(name="roleDAO")
	@Override
	public void setDao(RoleDAO dao) {
		this.dao=dao;
	}

}
