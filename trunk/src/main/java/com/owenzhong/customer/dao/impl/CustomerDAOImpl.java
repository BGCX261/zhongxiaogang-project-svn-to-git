package com.owenzhong.customer.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.owenzhong.customer.dao.CustomerDAO;
import com.owenzhong.customer.model.Customer;
import com.owenzhong.framework.dao.CustomHibernateDaoSupport;

@Repository("customerDAO")
public class CustomerDAOImpl extends CustomHibernateDaoSupport  implements CustomerDAO{
	
//	@PersistenceContext
//	private EntityManager em;
	//add the customer
	public void addCustomer(Customer customer){
		
		getHibernateTemplate().save(customer);
//		em.persist(customer);
		
	}
	
	//return all the customers in list
	public List<Customer> listCustomer(){
		
		return getHibernateTemplate().find("from Customer");
//		em.createQuery("from Customer");
	}
	
}