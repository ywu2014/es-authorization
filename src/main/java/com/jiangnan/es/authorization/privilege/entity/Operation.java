/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.privilege.entity;

import com.jiangnan.es.common.entity.BaseEntity;

/**
 * @description 操作
 * @author ywu@wuxicloud.com
 * 2016年1月16日 下午1:43:26
 */
public class Operation extends BaseEntity<Integer> {

	private static final long serialVersionUID = -8807381939825039386L;
	/**
	 * 标识
	 */
	private Integer id;
	/**
	 * 代号
	 */
	private String code;
	/**
	 * 描述
	 */
	private String description;

	@Override
	public Integer getId() {
		return id;
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

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Operation other = (Operation) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
}
