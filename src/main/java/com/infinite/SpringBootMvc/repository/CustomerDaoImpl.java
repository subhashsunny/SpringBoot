package com.infinite.SpringBootMvc.repository;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import com.infinite.SpringBootMvc.model.Customer;

@Repository
@EnableAsync(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
public class CustomerDaoImpl implements ICustomerDao{

	@Autowired
	private SessionFactory sfactory;
	
	public void setSfactory(SessionFactory sfactory) {
		this.sfactory = sfactory;
	}
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		Session scs=this.sfactory.getCurrentSession();
		List<Customer> ls=scs.createQuery("from Customer").list();
		return ls;
	}

	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = this.sfactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		return customer;
	}

	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session scs = this.sfactory.getCurrentSession();
		System.out.println("added successfully");
		scs.save(customer);
		return customer;
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = this.sfactory.getCurrentSession();
				Hibernate.initialize(customer);
				session.update(customer);
		
	}

	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = this.sfactory.getCurrentSession();
				Customer p = (Customer) session.load(Customer.class, new Integer(id));
				if (null != p) {
					session.delete(p);
				}
			}	
	}
