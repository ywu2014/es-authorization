/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.user.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;

import com.jiangnan.es.authorization.privilege.entity.Privilege;
import com.jiangnan.es.authorization.role.entity.Role;
import com.jiangnan.es.common.entity.BaseEntity;

/**
 * @description 登录用户实体
 * @author ywu@wuxicloud.com
 * 2016年1月14日 上午9:17:13
 */
public class User extends BaseEntity<Integer> {

	private static final long serialVersionUID = 8486709104645991251L;
	
	/**
	 * 标识
	 */
	private Integer id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 电子邮件
	 */
	private String email;
	/**
	 * 盐值
	 */
	private String salt;
	/**
	 * 头像
	 */
	private String icon;
	/**
	 * 创建时间
	 */
	private Date createTime = new Date();
	/**
	 * 上次访问时间
	 */
	private Date lastVisitTime;
	/**
	 * 同一个账号当前并发登录数
	 */
	private Integer currentLoginCount;
	/**
	 * 状态
	 */
	private UserState state = UserState.SIGN_OUT;
	/**
	 * 角色列表
	 */
	private Set<Role> roles = new HashSet<Role>();
	/**
	 * 权限列表
	 */
	private Set<Privilege> privileges = new HashSet<Privilege>();
	
	public User() {}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastVisitTime() {
		return lastVisitTime;
	}

	public void setLastVisitTime(Date lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}

	public Integer getCurrentLoginCount() {
		return currentLoginCount;
	}

	public void setCurrentLoginCount(Integer currentLoginCount) {
		this.currentLoginCount = currentLoginCount;
	}

	public UserState getState() {
		return state;
	}

	public void setState(UserState state) {
		this.state = state;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 设置随机盐值
	 */
	public void randomSalt() {
		setSalt(RandomStringUtils.randomAlphanumeric(10));
	}
}
