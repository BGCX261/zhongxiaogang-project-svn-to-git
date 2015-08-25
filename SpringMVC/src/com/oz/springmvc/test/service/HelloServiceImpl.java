package com.oz.springmvc.test.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.oz.springmvc.test.dao.HelloDao;
import com.oz.springmvc.test.domain.Hello;

public class HelloServiceImpl implements HelloService {

	private Logger log = Logger.getLogger(HelloServiceImpl.class);
	
	private HelloDao helloDao;
	
	public List<Hello> getData() {
		List<Hello> loadHelloList = getHelloDao().loadAll();
		return loadHelloList;
	}
	public void saveHello(Hello hello){
		hello = helloDao.save(hello);
		log.info("id -> : "+ hello.getId());
	}
	
	public void delteHello(Long id) {
		helloDao.delete(id);
	}
	public void setHelloDao(HelloDao helloDao) {
		this.helloDao = helloDao;
	}

	public HelloDao getHelloDao() {
		return helloDao;
	}

}
