/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.role.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiangnan.es.authorization.privilege.service.OperationService;
import com.jiangnan.es.authorization.role.entity.Role;
import com.jiangnan.es.authorization.role.service.RoleService;
import com.jiangnan.es.common.entity.query.Page;
import com.jiangnan.es.common.web.PageView;
import com.jiangnan.es.common.web.controller.BaseController;

/**
 * @description 角色控制器
 * @author ywu@wuxicloud.com
 * 2016年1月19日 下午5:59:57
 */
@Controller
@RequestMapping("system/auth/role/")
public class RoleController extends BaseController {
	
	@Resource
	RoleService roleService;
	@Resource
	OperationService operationService;
	
	/**
	 * 角色管理主页面
	 * @return
	 */
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("operations", operationService.list());
		return "system/auth/role/list";
	}
	
	/**
	 * 角色管理列表分页数据
	 * @param response
	 */
	@RequestMapping("list")
	public void list(Role role, HttpServletResponse response) {
		Page<Role> roles = roleService.list(role);
		super.jsonResponse(response, new PageView<Role>(roles));
	}
	
	/**
	 * 添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String toAdd(Model model) {
		addAction(model);
		return "system/auth/role/edit";
	}
	
	/**
	 * 添加角色
	 * @param role
	 * @param response
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(Role role, HttpServletResponse response) {
		roleService.save(role);
		super.jsonResponse(response, ajaxResult(1, "角色添加成功"));
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
		Role role = roleService.get(Role.class, id);
		model.addAttribute("role", role);
		return "system/auth/role/edit";
	}
	
	/**
	 * 更新角色
	 * @param role
	 * @param response
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(Role role, HttpServletResponse response) {
		roleService.update(role);
		super.jsonResponse(response, ajaxResult(1, "角色修改成功"));
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value = "delete/{id}")
	public void delete(@PathVariable("id") Integer id, HttpServletResponse response) {
		roleService.remove(Role.class, id);
		super.jsonResponse(response, ajaxResult(1, "角色删除成功"));
	}
	
	/**
	 * 角色授权页面
	 * @param rid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "privilege/list/{id}")
	public String toRoleList(@PathVariable("id") Integer rid, Model model) {
		model.addAttribute("rid", rid);
		return "system/auth/role/privilegeList";
	}
	
	/**
	 * 获取角色关联的权限id
	 * @param rid
	 * @param response
	 */
	@RequestMapping(value = "{id}/privileges")
	public void privilegeList(@PathVariable("id") Integer rid, HttpServletResponse response) {
		Role role = new Role();
		role.setId(rid);
		super.jsonResponse(response, roleService.getPrivilegeIds(role));
	}
	
	@RequestMapping(value = "{id}/privileges/update")
	public void privilegesUpdate(@PathVariable("id") Integer rid, String privilegeIds, String type, HttpServletResponse response) {
		Role role = new Role();
		role.setId(rid);
		roleService.updatePrivileges(role, type, privilegeIds);
		super.jsonResponse(response, ajaxResult(1, "授权更新成功"));
	}
}
