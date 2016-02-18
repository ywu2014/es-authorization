/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.role.entity;

import java.util.HashSet;
import java.util.Set;

import com.jiangnan.es.authorization.privilege.entity.Privilege;
import com.jiangnan.es.common.entity.BaseEntity;

/**
 * @description 角色实体
 * @author ywu@wuxicloud.com
 * 2016年1月13日 下午6:01:02
 */
public class Role extends BaseEntity<Integer> {

	private static final long serialVersionUID = 3671802873532807018L;
	
	/**
	 * 标识
	 */
	private Integer id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 标记
	 */
	private String code;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 权限集合
	 */
	private Set<Privilege> privileges = new HashSet<Privilege>();

	@Override
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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

}
