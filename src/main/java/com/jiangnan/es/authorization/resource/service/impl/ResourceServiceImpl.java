/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.resource.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiangnan.es.authorization.resource.dao.ResourceDao;
import com.jiangnan.es.authorization.resource.entity.Resource;
import com.jiangnan.es.authorization.resource.service.ResourceService;
import com.jiangnan.es.common.repository.BaseRepository;
import com.jiangnan.es.common.service.impl.BaseServiceSupport;
import com.jiangnan.es.util.CollectionUtils;

/**
 * @description 资源业务实现类
 * @author ywu@wuxicloud.com
 * 2016年1月4日 下午2:58:15
 */
@Service
public class ResourceServiceImpl extends BaseServiceSupport<Resource> implements ResourceService {
	
	@Autowired
	ResourceDao resourceDao;

	@Override
	public List<Resource> list() {
		return resourceDao.list(new Resource());
	}

	@Override
	public List<Resource> convertCascade(List<Resource> resources) {
		if (!CollectionUtils.isEmpty(resources)) {
			List<Resource> converted = new ArrayList<Resource>();
			for (Resource resource : resources) {
				Resource parent = getParent(resources, resource.getPid());
				if (null != parent) {
					parent.addChild(resource);
				}
			}
			for (Resource resource : resources) {
				Resource r = getParent(resources, resource.getPid());
				if (null == r) {
					converted.add(resource);
				}
			}
			return converted;
		}
		return resources;
	}

	/**
	 * 获取父资源
	 * @param resources
	 * @param parentId
	 * @return
	 */
	private Resource getParent(List<Resource> resources, Integer parentId) {
		for (Resource resource : resources) {
			if (null == parentId) {
				return null;
			} else if (resource.getId().intValue() == parentId.intValue()) {
				return resource;
			}
		}
		return null;
	}

	@Override
	protected BaseRepository<Resource> getRepository() {
		return resourceDao;
	}
}
