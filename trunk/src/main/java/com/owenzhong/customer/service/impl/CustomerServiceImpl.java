package com.owenzhong.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owenzhong.customer.dao.CustomerDAO;
import com.owenzhong.customer.model.Customer;
import com.owenzhong.customer.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDAO customerDAO;

	//DI via Spring
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	//call DAO to save customer
	public void addCustomer(Customer customer){
		
		customerDAO.addCustomer(customer);
		
	}
	
	//call DAO to return customers
	public List<Customer> listCustomer(){
		
		return customerDAO.listCustomer();
		
	}
	
}