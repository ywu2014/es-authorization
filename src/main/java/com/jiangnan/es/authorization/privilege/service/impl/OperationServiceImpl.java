/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.privilege.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jiangnan.es.authorization.privilege.dao.OperationDao;
import com.jiangnan.es.authorization.privilege.entity.Operation;
import com.jiangnan.es.authorization.privilege.service.OperationService;
import com.jiangnan.es.common.repository.BaseRepository;
import com.jiangnan.es.common.service.impl.BaseServiceSupport;

/**
 * @description 操作业务实现
 * @author ywu@wuxicloud.com
 * 2016年1月18日 下午1:24:11
 */
@Service
public class OperationServiceImpl extends BaseServiceSupport<Operation> implements OperationService {
	
	@javax.annotation.Resource
	OperationDao operationDao;

	@Override
	public List<Operation> list() {
		return operationDao.list();
	}

	@Override
	protected BaseRepository<Operation> getRepository() {
		return operationDao;
	}

}
