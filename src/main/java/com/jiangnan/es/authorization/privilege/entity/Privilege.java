/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.privilege.entity;

import com.jiangnan.es.authorization.resource.entity.Resource;
import com.jiangnan.es.common.entity.BaseEntity;

/**
 * @description 权限实体,表现为对资源的操作
 * @author ywu@wuxicloud.com
 * 2016年1月13日 下午1:43:52
 */
public class Privilege extends BaseEntity<Integer> {

	private static final long serialVersionUID = -8188867546110605689L;
	
	/**
	 * 标识
	 */
	private Integer id;
	/**
	 * 资源
	 */
	private Resource resource;
	/**
	 * 操作
	 */
	private Operation operation;
	/**
	 * 描述
	 */
	private String description;
	
	@Override
	public Integer getId() {
		return id;
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

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((operation == null) ? 0 : operation.hashCode());
		result = prime * result
				+ ((resource == null) ? 0 : resource.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Privilege other = (Privilege) obj;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		if (resource == null) {
			if (other.resource != null)
				return false;
		} else if (!resource.equals(other.resource))
			return false;
		return true;
	}

}
