/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.user.exception;

import com.jiangnan.es.common.exception.ApplicationException;

/**
 * @description 密码不匹配异常
 * @author ywu@wuxicloud.com
 * 2016年2月18日 上午10:47:30
 */
public class PasswordNotMatchException extends ApplicationException {

	private static final long serialVersionUID = 5689384250694419954L;
	
	/**
	 * @param code
	 * @param defaultMessage
	 * @param args
	 */
	public PasswordNotMatchException(String code, String defaultMessage,
			Object[] args) {
		super(code, defaultMessage, args);
	}

	public PasswordNotMatchException() {
		this("user.password.not.match", null, null);
	}
}
