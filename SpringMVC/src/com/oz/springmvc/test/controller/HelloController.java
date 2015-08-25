package com.oz.springmvc.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.oz.springmvc.test.service.HelloService;

public class HelloController implements Controller {
	private HelloService helloService;
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		return new ModelAndView("index","list",helloService.getData());
	}
	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
}
