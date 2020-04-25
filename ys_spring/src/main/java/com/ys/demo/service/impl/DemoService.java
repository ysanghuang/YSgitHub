package com.ys.demo.service.impl;


import com.ys.demo.service.IDemoService;
import com.ys.springframework.annotation.YSService;

/**
 * 核心业务逻辑
 */
@YSService
public class DemoService implements IDemoService {

	public String get(String name) {
		return "My name is " + name + ",from service.";
	}

}
