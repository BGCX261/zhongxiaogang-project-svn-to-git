package com.oz.springmvc.test.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.oz.springmvc.test.domain.Hello;
import com.oz.springmvc.test.service.HelloService;

public class FormController extends SimpleFormController{
	private HelloService helloService;
	protected ModelAndView onSubmit(Object command) throws Exception {
		Hello hello =(Hello) command;
		helloService.saveHello(hello);
		return new ModelAndView(new RedirectView(getSuccessView()));
	}
	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
}
