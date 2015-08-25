package com.owenzhong.customer.dao;

import java.util.List;

import com.owenzhong.customer.model.Customer;
 
public interface CustomerDAO{
	
	void addCustomer(Customer customer);
	
	List<Customer> listCustomer();
	
}