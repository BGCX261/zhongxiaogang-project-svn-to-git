package com.owenzhong.customer.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.owenzhong.customer.model.Customer;
import com.owenzhong.customer.service.CustomerService;

@Controller
public class CustomerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer = null;
	private List<Customer> customerList = null;
	
	@Autowired
	private CustomerService customerService;

	
	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	//save customer
	public String addCustomer() throws Exception{
		
		//save it
		getCustomer().setCreatedDate(new Date());
		customerService.addCustomer(getCustomer());
	 
		//reload the customer list
		customerList = null;
		customerList = customerService.listCustomer();
		return "success";
	
	}
	
	//list all customers
	public String listCustomer() throws Exception{
		
		customerList = customerService.listCustomer();
		
		return "success";
	
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}
	
}