/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiangnan.es.authorization.user.dao.UserDao;
import com.jiangnan.es.authorization.user.entity.User;
import com.jiangnan.es.authorization.user.service.PasswordService;
import com.jiangnan.es.authorization.user.service.UserService;
import com.jiangnan.es.common.entity.query.Page;
import com.jiangnan.es.common.repository.BaseRepository;
import com.jiangnan.es.orm.mybatis.plugin.PageHelper;
import com.jiangnan.es.orm.mybatis.service.MybatisBaseServiceSupport;
import com.jiangnan.es.util.StringUtils;

/**
 * @description 登录用户业务操作实现类
 * @author ywu@wuxicloud.com
 * 2016年1月14日 上午10:22:32
 */
@Service
public class UserServiceImpl extends MybatisBaseServiceSupport<User> implements UserService {
	
	@Resource
	UserDao userDao;
	@Resource
	PasswordService passwordService;

	@Override
	public User save(User user) {
		//生成salt, 加密password
		if (!StringUtils.hasText(user.getSalt())) {
			user.randomSalt();
		}
		user.setPassword(passwordService.encrypt(user));
		super.save(user);
		return user;
	}
	
	@Override
	public List<Integer> getRoleIds(User user) {
		return userDao.getRoleIds(user);
	}

	@Override
	protected BaseRepository<User> getRepository() {
		return userDao;
	}

	@Override
	public void updateRoles(User user, String roleIds, String type) {
		//添加用户角色
		if (StringUtils.hasLength(roleIds)) {
			if ("add".equals(type)) {
				for (String roleId : StringUtils.split(roleIds, ",")) {
					Map<String, Integer> userRole = new HashMap<String, Integer>(2);
					userRole.put("uid", user.getId());
					userRole.put("rid", Integer.valueOf(roleId));
					userDao.addUserRole(userRole);
				}
			} else if ("del".equals(type)) {
				for (String roleId : StringUtils.split(roleIds, ",")) {
					userDao.removeUserRole(user.getId(), Integer.valueOf(roleId));
				}
			}
		}
	}

	@Override
	public Page<User> listMap(Map<String, Object> params) {
		PageHelper.startPage();
		List<User> users = userDao.list(params);
		return PageHelper.getPageResult(users);
	}

	@Override
	public User findByUserName(String userName) {
		if (StringUtils.hasText(userName)) {
			return userDao.findByUserName(userName.trim());
		}
		return null;
	}

}
