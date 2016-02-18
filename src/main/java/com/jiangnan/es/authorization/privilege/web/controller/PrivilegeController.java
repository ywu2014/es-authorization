/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.privilege.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiangnan.es.authorization.privilege.entity.Operation;
import com.jiangnan.es.authorization.privilege.entity.Privilege;
import com.jiangnan.es.authorization.privilege.entity.PrivilegeResourceOperation;
import com.jiangnan.es.authorization.privilege.service.OperationService;
import com.jiangnan.es.authorization.privilege.service.PrivilegeService;
import com.jiangnan.es.authorization.resource.entity.Resource;
import com.jiangnan.es.authorization.resource.service.ResourceService;
import com.jiangnan.es.common.entity.query.Page;
import com.jiangnan.es.common.web.PageView;
import com.jiangnan.es.common.web.controller.BaseController;

/**
 * @description 权限控制器
 * @author ywu@wuxicloud.com
 * 2016年1月17日 下午8:20:42
 */
@Controller
@RequestMapping("system/auth/privilege/")
public class PrivilegeController extends BaseController {
	
	@javax.annotation.Resource
	PrivilegeService privilegeService;
	@javax.annotation.Resource
	OperationService operationService;
	@javax.annotation.Resource
	ResourceService resourceService;
	
	/**
	 * 权限列表
	 * @return
	 */
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("operations", operationService.list());
		return "system/auth/privilege/list";
	}
	
	@RequestMapping("list")
	public void list(String resourceName, Integer operationId, HttpServletResponse response) {
		Privilege privilege = new Privilege();
		Resource resource = new Resource();
		resource.setName(resourceName);
		privilege.setResource(resource);
		Operation operation = new Operation();
		operation.setId(operationId);
		privilege.setOperation(operation);
		Page<PrivilegeResourceOperation> privileges = privilegeService.list(privilege);
		super.jsonResponse(response, new PageView<PrivilegeResourceOperation>(privileges));
	}
	
	/**
	 * 添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String toAdd(Model model) {
		addAction(model);
		model.addAttribute("operations", operationService.list());
		
		List<Resource> resources = resourceService.list();
		model.addAttribute("resources", resources);
		
		return "system/auth/privilege/edit";
	}
	
	/**
	 * 添加权限
	 * @param privilege
	 * @param response
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(Privilege privilege, HttpServletResponse response) {
		privilegeService.save(privilege);;
		super.jsonResponse(response, ajaxResult(1, "权限添加成功"));
	}
	
	/**
	 * 修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String toUpdate(@PathVariable(value = "id") Integer id, Model model) {
		updateAction(model);
		Privilege privilege = privilegeService.get(Privilege.class, id);
		model.addAttribute("privilege", privilege);
		model.addAttribute("operations", operationService.list());
		return "system/auth/privilege/edit";
	}
	
	/**
	 * 更新权限
	 * @param user
	 * @param response
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(Privilege privilege, HttpServletResponse response) {
		privilegeService.update(privilege);;
		super.jsonResponse(response, ajaxResult(1, "权限修改成功"));
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value = "delete/{id}")
	public void delete(@PathVariable("id") Integer id, HttpServletResponse response) {
		privilegeService.remove(Privilege.class, id);
		super.jsonResponse(response, ajaxResult(1, "权限删除成功"));
	}
}
