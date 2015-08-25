package com.oz.springmvc.test.service;

import java.util.List;

import com.oz.springmvc.test.domain.Hello;

public interface HelloService {
	public List<Hello> getData();

	public void saveHello(Hello hello);
	
	public void delteHello(Long id);
}
