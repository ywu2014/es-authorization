/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.privilege.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiangnan.es.authorization.privilege.entity.Operation;
import com.jiangnan.es.authorization.privilege.service.OperationService;
import com.jiangnan.es.common.web.controller.BaseController;

/**
 * @description 权限操作控制器
 * @author ywu@wuxicloud.com
 * 2016年1月19日 下午4:53:59
 */
@Controller
@RequestMapping("system/auth/operation/")
public class OperationController extends BaseController {
	
	@Resource
	OperationService operationService;
	
	/**
	 * 添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String toAdd(Model model) {
		addAction(model);
		return "system/auth/operation/edit";
	}
	
	/**
	 * 添加权限
	 * @param privilege
	 * @param response
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(Operation operation, HttpServletResponse response) {
		operationService.save(operation);;
		super.jsonResponse(response, ajaxResult(1, "操作添加成功"));
	}
}
