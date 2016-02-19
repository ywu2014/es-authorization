/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.role.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiangnan.es.authorization.privilege.entity.Operation;
import com.jiangnan.es.authorization.privilege.entity.Privilege;
import com.jiangnan.es.authorization.privilege.service.OperationService;
import com.jiangnan.es.authorization.privilege.service.PrivilegeService;
import com.jiangnan.es.authorization.resource.service.ResourceService;
import com.jiangnan.es.authorization.role.dao.RoleDao;
import com.jiangnan.es.authorization.role.entity.Role;
import com.jiangnan.es.authorization.role.service.RoleService;
import com.jiangnan.es.common.repository.BaseRepository;
import com.jiangnan.es.orm.mybatis.service.MybatisBaseServiceSupport;
import com.jiangnan.es.util.CollectionUtils;
import com.jiangnan.es.util.StringUtils;

/**
 * @description 角色管理业务层实现类
 * @author ywu@wuxicloud.com
 * 2016年1月19日 下午4:34:37
 */
@Service
public class RoleServiceImpl extends MybatisBaseServiceSupport<Role> implements RoleService {

	@Resource
	RoleDao roleDao;
	@Resource
	PrivilegeService privilegeService;
	@Resource
	OperationService operationService;
	@Resource
	ResourceService resourceService;
	
	@Override
	protected BaseRepository<Role> getRepository() {
		return roleDao;
	}

	@Override
	public List<Integer> getPrivilegeIds(Role role) {
		return roleDao.getPrivilegeIds(role);
	}

	@Override
	public void updatePrivileges(Role role, String type, String privilegeIds) {
		if (StringUtils.hasText(privilegeIds)) {
			for (String privilegeId : StringUtils.split(privilegeIds, ",")) {
				if ("add".equals(type)) {
					Integer count = roleDao.countRolePrivilege(role.getId(), Integer.valueOf(privilegeId));
					if (!(count > 0)) {
						roleDao.addRolePrivilege(role.getId(), Integer.valueOf(privilegeId));
					}
				} else if ("del".equals(type)) {
					roleDao.removeRolePrivilege(role.getId(), Integer.valueOf(privilegeId));
				}
			}
		}
	}

	@Override
	public Set<Privilege> getPrivileges(Role role) {
		//List<Integer> privilegeIds = ((RoleService)AopContext.currentProxy()).getPrivilegeIds(role);
		List<Integer> privilegeIds = this.getPrivilegeIds(role);
		Set<Privilege> privileges = new HashSet<Privilege>();
		if (!CollectionUtils.isEmpty(privilegeIds)) {
			for (Integer privilegeId : privilegeIds) {
				Privilege privilege = privilegeService.get(Privilege.class, privilegeId);
				Operation operation = operationService.get(Operation.class, privilege.getOperation().getId());
				privilege.setOperation(operation);
				com.jiangnan.es.authorization.resource.entity.Resource resource 
					= resourceService.get(com.jiangnan.es.authorization.resource.entity.Resource.class, privilege.getResource().getId());
				privilege.setResource(resource);
				privileges.add(privilege);
			}
		}
		return privileges;
	}

}
