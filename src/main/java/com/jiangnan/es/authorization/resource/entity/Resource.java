/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.resource.entity;

import java.util.HashSet;
import java.util.Set;

import com.jiangnan.es.common.entity.BaseEntity;

/**
 * @description 资源实体,包括菜单、链接、按钮、文件等
 * @author ywu@wuxicloud.com
 * 2016年1月4日 下午2:00:03
 */
public class Resource extends BaseEntity<Integer> {

	private static final long serialVersionUID = -9155425008451376233L;
	
	/**
	 * 标识
	 */
	private Integer id;
	/**
	 * 资源名称,页面中使用
	 */
	private String name;
	/**
	 * 资源标记,程序中使用
	 */
	private String identifier;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 资源图标
	 */
	private String icon;
	/**
	 * 父资源
	 */
	private Resource parent;
	/**
	 * 父级资源id
	 */
	private Integer pid;
	/**
	 * 子资源
	 */
	private Set<Resource> children = new HashSet<Resource>(0);
	/**
	 * 资源类型
	 */
	private ResourceType type;
	/**
     * 点击后前往的地址
     */
    private String url;
    /**
     * 排序
     */
    private Integer sort = 0;

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Resource getParent() {
		return parent;
	}

	public void setParent(Resource parent) {
		this.parent = parent;
	}

	public Set<Resource> getChildren() {
		return children;
	}

	public void setChildren(Set<Resource> children) {
		this.children = children;
	}
	
	/**
	 * 添加子资源
	 * @param resource
	 */
	public void addChild(Resource resource) {
		this.children.add(resource);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	/**
	 * 是否有子资源
	 * @return
	 */
	public boolean isHasChildren() {
		return !getChildren().isEmpty();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Resource other = (Resource) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
}
