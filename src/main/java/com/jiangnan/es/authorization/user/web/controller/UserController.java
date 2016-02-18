/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.user.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiangnan.es.authorization.user.entity.User;
import com.jiangnan.es.authorization.user.service.UserService;
import com.jiangnan.es.common.entity.query.Page;
import com.jiangnan.es.common.web.PageView;
import com.jiangnan.es.common.web.controller.BaseController;

/**
 * @description 登录用户控制器
 * @author ywu@wuxicloud.com
 * 2016年1月14日 上午10:25:41
 */
@Controller
@RequestMapping("system/auth/user/")
public class UserController extends BaseController {
	@Resource
	UserService userService;
	
	/**
	 * 用户管理主页面
	 * @return
	 */
	@RequestMapping("/")
	public String main(Model model) {
		return "system/auth/user/list";
	}
	
	/**
	 * 用户管理列表分页数据
	 * @param response
	 */
	@RequestMapping("list")
	public void list(String userName, String email, Date startVisitTime, Date endVisitTime, HttpServletResponse response) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		params.put("email", email);
		params.put("startVisitTime", startVisitTime);
		params.put("endVisitTime", endVisitTime);
		Page<User> users = userService.listMap(params);
		super.jsonResponse(response, new PageView<User>(users));
	}
	
	/**
	 * 添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String toAdd(Model model) {
		addAction(model);
		return "system/auth/user/edit";
	}
	
	/**
	 * 添加用户
	 * @param resource
	 * @param response
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(User user, HttpServletResponse response) {
		userService.save(user);
		super.jsonResponse(response, ajaxResult(1, "用户添加成功"));
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
		User user = userService.get(User.class, id);
		model.addAttribute("user", user);
		return "system/auth/user/edit";
	}
	
	/**
	 * 更新登录用户
	 * @param user
	 * @param response
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(User user, HttpServletResponse response) {
		userService.update(user);
		super.jsonResponse(response, ajaxResult(1, "用户修改成功"));
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value = "delete/{id}")
	public void delete(@PathVariable("id") Integer id, HttpServletResponse response) {
		userService.remove(User.class, id);
		super.jsonResponse(response, ajaxResult(1, "用户删除成功"));
	}
	
	/**
	 * 用户授权页面
	 * @param uid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "role/list/{id}")
	public String toRoleList(@PathVariable("id") Integer uid, Model model) {
		model.addAttribute("uid", uid);
		return "system/auth/user/roleList";
	}
	
	/**
	 * 用户授予角色id
	 * @param uid
	 * @param model
	 * @param response
	 */
	@RequestMapping(value = "{id}/roles")
	public void roleList(@PathVariable("id") Integer uid, Model model, HttpServletResponse response) {
		User user = new User();
		user.setId(uid);
		super.jsonResponse(response, userService.getRoleIds(user));
	}
	
	/**
	 * 修改用户授予角色
	 * @param uid
	 * @param roles
	 * @param type 操作类型,add:del
	 * @param response
	 */
	@RequestMapping(value = "{id}/roles/update")
	public void updateRoles(@PathVariable("id") Integer uid, String roles, String type, HttpServletResponse response) {
		User user = new User();
		user.setId(uid);
		userService.updateRoles(user, roles, type);
		super.jsonResponse(response, ajaxResult(1, "角色修改成功"));
	}
}
