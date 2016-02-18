/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es;

import java.io.IOException;

import org.junit.Test;

import com.jiangnan.es.authorization.role.dao.RoleDao;
import com.jiangnan.es.authorization.role.entity.Role;
import com.jiangnan.es.orm.mybatis.util.MybatisMapperXmlGenerator;

/**
 * @description xml mapper测试
 * @author ywu@wuxicloud.com
 * 2016年1月12日 下午4:56:10
 */
public class MapperXmlGeneratorTest {

	@Test
	public void testGenerator() {
		MybatisMapperXmlGenerator generator = new MybatisMapperXmlGenerator(Role.class, RoleDao.class, "d:/");
		//generator.setIncludeParentProperty(true);
		try {
			generator.generate();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
