/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.privilege.entity;

import com.jiangnan.es.common.entity.BaseEntity;

/**
 * @description 资源、操作组合,前台展示使用
 * @author ywu@wuxicloud.com
 * 2016年1月18日 下午3:30:30
 */
public class PrivilegeResourceOperation extends BaseEntity<Integer> {

	private static final long serialVersionUID = -3203568465234947927L;
	/**
	 * 权限id
	 */
	private Integer id;
	/**
	 * 资源id
	 */
	private Integer resourceId;
	/**
	 * 资源名称
	 */
	private String resourceName;
	/**
	 * 操作id
	 */
	private Integer operationId;
	/**
	 * 操作
	 */
	private String operation;
	/**
	 * 权限描述
	 */
	private String description;

	@Override
	public Integer getId() {
		return this.id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getOperationId() {
		return operationId;
	}

	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

}
