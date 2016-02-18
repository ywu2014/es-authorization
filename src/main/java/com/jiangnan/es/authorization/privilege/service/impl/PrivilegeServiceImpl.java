/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.privilege.service.impl;

import org.springframework.stereotype.Service;

import com.jiangnan.es.authorization.privilege.dao.PrivilegeDao;
import com.jiangnan.es.authorization.privilege.entity.Privilege;
import com.jiangnan.es.authorization.privilege.service.PrivilegeService;
import com.jiangnan.es.common.repository.BaseRepository;
import com.jiangnan.es.orm.mybatis.service.MybatisBaseServiceSupport;

/**
 * @description 权限业务实现类
 * @author ywu@wuxicloud.com
 * 2016年1月18日 下午1:47:51
 */
@Service
public class PrivilegeServiceImpl extends MybatisBaseServiceSupport<Privilege> implements PrivilegeService {
	
	@javax.annotation.Resource
	PrivilegeDao privilegeDao;

	@Override
	protected BaseRepository<Privilege> getRepository() {
		return privilegeDao;
	}

}
