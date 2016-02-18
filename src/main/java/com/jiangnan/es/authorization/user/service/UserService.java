/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.user.service;

import java.util.List;
import java.util.Map;

import com.jiangnan.es.authorization.user.entity.User;
import com.jiangnan.es.common.entity.query.Page;
import com.jiangnan.es.orm.mybatis.service.MybatisBaseService;


/**
 * @description 登录用户业务操作接口
 * @author ywu@wuxicloud.com
 * 2016年1月14日 上午10:22:13
 */
public interface UserService extends MybatisBaseService<User> {
	/**
	 * 获取用户授予权限的id
	 * @param user
	 * @return
	 */
	public List<Integer> getRoleIds(User user);
	/**
	 * 修改用户角色信息
	 * @param user
	 * @param roleIds
	 * @param type add:del,添加或删除
	 */
	public void updateRoles(User user, String roleIds, String type);
	/**
	 * map参数查询用户列表
	 * @param params
	 * @return
	 */
	public Page<User> listMap(Map<String, Object> params);
	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	public User findByUserName(String userName);
}
