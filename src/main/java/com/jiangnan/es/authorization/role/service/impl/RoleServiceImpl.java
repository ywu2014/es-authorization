/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.role.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiangnan.es.authorization.role.dao.RoleDao;
import com.jiangnan.es.authorization.role.entity.Role;
import com.jiangnan.es.authorization.role.service.RoleService;
import com.jiangnan.es.common.repository.BaseRepository;
import com.jiangnan.es.orm.mybatis.service.MybatisBaseServiceSupport;
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

}
