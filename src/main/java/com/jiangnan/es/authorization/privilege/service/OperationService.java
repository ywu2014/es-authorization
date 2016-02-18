/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.privilege.service;

import java.util.List;

import com.jiangnan.es.authorization.privilege.entity.Operation;
import com.jiangnan.es.common.service.BaseService;

/**
 * @description 操作业务接口
 * @author ywu@wuxicloud.com
 * 2016年1月18日 下午1:23:30
 */
public interface OperationService extends BaseService<Operation> {
	/**
	 * 获取操作列表
	 * @return
	 */
	List<Operation> list();
}
