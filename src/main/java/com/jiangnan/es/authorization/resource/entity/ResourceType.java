/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.authorization.resource.entity;

/**
 * @description 资源类型
 * @author ywu@wuxicloud.com
 * 2016年1月4日 下午2:46:23
 */
public enum ResourceType {
	menu {
		@Override
		public String getName() {
			return "菜单";
		}
	}, button {
		@Override
		public String getName() {
			return "按钮";
		}
	}, link {
		@Override
		public String getName() {
			return "超链接";
		}
	}, file {
		@Override
		public String getName() {
			return "文件";
		}
	};
	
	/**
	 * 资源名称
	 * @return
	 */
	public abstract String getName();
}
