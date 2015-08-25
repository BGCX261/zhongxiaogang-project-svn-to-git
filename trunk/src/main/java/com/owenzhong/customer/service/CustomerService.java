package com.owenzhong.customer.service;

import java.util.List;

import com.owenzhong.customer.model.Customer;
 
public interface CustomerService{
	
	void addCustomer(Customer customer);
	
	List<Customer> listCustomer();
	
}