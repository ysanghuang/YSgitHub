package com.ys.demo.controller;

import com.ys.demo.service.IDemoService;
import com.ys.springframework.annotation.YSAutowire;
import com.ys.springframework.annotation.YSController;
import com.ys.springframework.annotation.YSRequestMapping;
import com.ys.springframework.annotation.YSRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//虽然，用法一样，但是没有功能
@YSController
@YSRequestMapping("/demo")
public class DemoAction {

	@YSAutowire
	private IDemoService demoService;

	@YSRequestMapping("/query")
	public void query(HttpServletRequest req, HttpServletResponse resp,
					  @YSRequestParam("name") String name){
		String result = demoService.get(name);
//		String result = "My name is " + name;
		try {
			resp.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@YSRequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp,
					@YSRequestParam("a") Integer a, @YSRequestParam("b") Integer b){
		try {
			resp.getWriter().write(a + "+" + b + "=" + (a + b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@YSRequestMapping("/sub")
	public void add(HttpServletRequest req, HttpServletResponse resp,
					@YSRequestParam("a") Double a, @YSRequestParam("b") Double b){
		try {
			resp.getWriter().write(a + "-" + b + "=" + (a - b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@YSRequestMapping("/remove")
	public String  remove(@YSRequestParam("id") Integer id){
		return "" + id;
	}

}
