/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.resource.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiangnan.es.authorization.resource.entity.Resource;
import com.jiangnan.es.authorization.resource.entity.ResourceType;
import com.jiangnan.es.authorization.resource.service.ResourceService;
import com.jiangnan.es.common.web.controller.BaseController;

/**
 * @description 资源管理控制器
 * @author ywu@wuxicloud.com
 * 2016年1月6日 下午8:14:50
 */
@Controller
@RequestMapping("system/auth/resource/")
public class ResourceController extends BaseController {
	
	@javax.annotation.Resource
	ResourceService resourceService;
	
	/**
	 * 资源管理主页面
	 * @return
	 */
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("resourceTypes", ResourceType.values());
		List<Resource> resources = resourceService.list();
		List<Resource> cascadeResources = resourceService.convertCascade(resources);
		List<Resource> r = new ArrayList<Resource>(resources.size());
		for (Resource resource : cascadeResources) {
			addResource(r, resource);
		}
		model.addAttribute("resources", r);
		return "system/auth/resource/list";
	}
	
	private void addResource(List<Resource> r, Resource resource) {
		r.add(resource);
		if (resource.isHasChildren()) {
			for (Resource res : resource.getChildren()) {
				addResource(r, res);
			}
		}
	}
	
	/**
	 * 
	 * @param response
	 */
	@RequestMapping("json")
	public void json(HttpServletResponse response) {
		super.jsonResponse(response, resourceService.list());
	}
	
	/**
	 * 添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String toAdd(Model model) {
		addAction(model);
		model.addAttribute("resourceTypes", ResourceType.values());
		
		List<Resource> resources = resourceService.list();
		model.addAttribute("resources", resources);
		
		return "system/auth/resource/edit";
	}
	
	/**
	 * 添加资源
	 * @param resource
	 * @param response
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(Resource resource, HttpServletResponse response) {
		resourceService.save(resource);
		super.jsonResponse(response, ajaxResult(1, "资源添加成功"));
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
		Resource resource = resourceService.get(Resource.class, id);
		model.addAttribute("resource", resource);
		model.addAttribute("resourceTypes", ResourceType.values());
		List<Resource> resources = resourceService.list();
		model.addAttribute("resources", resources);
		return "system/auth/resource/edit";
	}
	
	/**
	 * 更新资源
	 * @param resource
	 * @param response
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(Resource resource, HttpServletResponse response) {
		resourceService.update(resource);
		super.jsonResponse(response, ajaxResult(1, "资源修改成功"));
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value = "delete/{id}")
	public void delete(@PathVariable("id") Integer id, HttpServletResponse response) {
		resourceService.remove(Resource.class, id);
		super.jsonResponse(response, ajaxResult(1, "资源删除成功"));
	}
	
}
