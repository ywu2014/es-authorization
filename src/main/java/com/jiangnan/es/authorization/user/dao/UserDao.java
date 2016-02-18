/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.user.dao;

import java.util.List;
import java.util.Map;

import com.jiangnan.es.authorization.user.entity.User;
import com.jiangnan.es.common.repository.BaseRepository;

/**
 * @description 登录用户dao
 * @author ywu@wuxicloud.com
 * 2016年1月14日 上午10:01:38
 */
public interface UserDao extends BaseRepository<User> {
	/**
	 * 获取用户授予的角色id
	 * @param user
	 * @return
	 */
	List<Integer> getRoleIds(User user);
	/**
	 * 移除用户角色关联
	 * @param user
	 */
	void removeUserRoles(User user);
	/**
	 * 添加用户角色关联
	 * @param userRole
	 */
	void addUserRole(Map<String, Integer> userRole);
	/**
	 * 移除用户角色关联
	 * @param uid
	 * @param roleId
	 */
	void removeUserRole(Integer uid, Integer roleId);
	/**
	 * 分页
	 * @param params
	 * @return
	 */
	List<User> list(Map<String, Object> params);
	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	public User findByUserName(String userName);
}
