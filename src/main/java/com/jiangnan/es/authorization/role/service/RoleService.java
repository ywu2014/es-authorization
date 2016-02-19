/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.role.service;

import java.util.List;
import java.util.Set;

import com.jiangnan.es.authorization.privilege.entity.Privilege;
import com.jiangnan.es.authorization.role.entity.Role;
import com.jiangnan.es.orm.mybatis.service.MybatisBaseService;

/**
 * @description 角色管理业务层接口
 * @author ywu@wuxicloud.com
 * 2016年1月19日 下午3:45:51
 */
public interface RoleService extends MybatisBaseService<Role> {
	/**
	 * 获取角色关联的权限id
	 * @param role
	 * @return
	 */
	List<Integer> getPrivilegeIds(Role role);
	/**
	 * 获取权限集合
	 * @param role
	 * @return
	 */
	Set<Privilege> getPrivileges(Role role);
	/**
	 * 更新
	 * @param role
	 * @param type
	 * @param privilegeIds
	 */
	void updatePrivileges(Role role, String type, String privilegeIds);
}
