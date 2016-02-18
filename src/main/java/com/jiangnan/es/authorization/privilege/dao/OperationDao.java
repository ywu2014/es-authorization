/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.privilege.dao;

import java.util.List;

import com.jiangnan.es.authorization.privilege.entity.Operation;
import com.jiangnan.es.common.repository.BaseRepository;

/**
 * @description 操作dao
 * @author ywu@wuxicloud.com
 * 2016年1月16日 下午1:45:45
 */
public interface OperationDao extends BaseRepository<Operation> {
	/**
	 * 操作列表
	 * @return
	 */
	List<Operation> list();
}
