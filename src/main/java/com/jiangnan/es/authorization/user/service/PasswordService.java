/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.user.service;

import com.jiangnan.es.authorization.user.entity.User;
import com.jiangnan.es.authorization.user.exception.PasswordNotMatchException;

/**
 * @description 用户密码加密处理
 * @author ywu@wuxicloud.com
 * 2016年2月18日 上午10:37:36
 */
public interface PasswordService {
	/**
	 * 密码加密
	 * @param user
	 * @return
	 */
	public String encrypt(User user);

	/**
	 * 密码验证
	 * @param user 用户对象,从db中查询而来
	 * @param originPassword 原始密码,即用户页面输入的明文密码
	 * @throws PasswordNotMatchException
	 */
	public void validate(User user, String originPassword) throws PasswordNotMatchException;
}
