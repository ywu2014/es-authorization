/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.role.dao;

import java.util.List;

import com.jiangnan.es.authorization.role.entity.Role;
import com.jiangnan.es.common.repository.BaseRepository;

/**
 * @description 角色dao
 * @author ywu@wuxicloud.com
 * 2016年1月13日 下午6:12:41
 */
public interface RoleDao extends BaseRepository<Role> {
	/**
	 * 获取角色关联的权限id
	 * @param role
	 * @return
	 */
	List<Integer> getPrivilegeIds(Role role);
	/**
	 * 删除角色权限
	 * @param roleId
	 * @param privilegeId
	 */
	void removeRolePrivilege(Integer roleId, Integer privilegeId);
	/**
	 * 统计角色权限数量
	 * @param roleId
	 * @param privilegeId
	 * @return
	 */
	Integer countRolePrivilege(Integer roleId, Integer privilegeId);
	/**
	 * 添加角色权限关联
	 * @param roleId
	 * @param privilegeId
	 */
	void addRolePrivilege(Integer roleId, Integer privilegeId);
}
