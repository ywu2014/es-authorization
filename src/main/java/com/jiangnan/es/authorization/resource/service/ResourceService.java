/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.resource.service;

import java.util.List;

import com.jiangnan.es.authorization.resource.entity.Resource;
import com.jiangnan.es.common.service.BaseService;

/**
 * @description 资源业务接口定义
 * @author ywu@wuxicloud.com
 * 2016年1月4日 下午2:54:29
 */
public interface ResourceService extends BaseService<Resource> {
	/**
	 * 查询所有资源
	 * @return
	 */
	public List<Resource> list();
	/**
	 * 转换成父子结构
	 * @param resources
	 * @return
	 */
	public List<Resource> convertCascade(List<Resource> resources);
}
