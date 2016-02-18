/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.user.service.impl;

import com.jiangnan.es.authorization.user.entity.User;
import com.jiangnan.es.authorization.user.exception.PasswordNotMatchException;
import com.jiangnan.es.authorization.user.service.PasswordService;
import com.jiangnan.es.util.EncryptionUtils;

/**
 * @description 默认密码处理实现类
 * @author ywu@wuxicloud.com
 * 2016年2月18日 上午10:51:58
 */
public class DefaultPasswordServiceImpl implements PasswordService {

	@Override
	public String encrypt(User user) {
		return EncryptionUtils.md5(user.getUserName() + user.getPassword() + user.getSalt());
	}

	@Override
	public void validate(User user, String originPassword)
			throws PasswordNotMatchException {
		String encryptedPassword = EncryptionUtils.md5(user.getUserName() + originPassword + user.getSalt());
		if (!encryptedPassword.equals(user.getPassword())) {
			throw new PasswordNotMatchException();
		}
	}

}
