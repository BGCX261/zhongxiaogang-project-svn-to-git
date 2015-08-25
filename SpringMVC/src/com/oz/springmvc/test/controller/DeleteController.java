package com.oz.springmvc.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.oz.springmvc.test.service.HelloService;

public class DeleteController implements Controller {
	private HelloService helloService;
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		Long id = Long.valueOf(arg0.getParameter("id"));
		helloService.delteHello(id);
		ModelAndView modelAndView = new ModelAndView("message");
		modelAndView.addObject("message", "msg.deletesuccess");
		modelAndView.addObject("url", "hello.htm");
		return modelAndView;
	}
	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
}
