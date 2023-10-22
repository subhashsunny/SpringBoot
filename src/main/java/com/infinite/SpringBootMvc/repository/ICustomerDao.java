package com.infinite.SpringBootMvc.repository;

import java.util.List;
import com.infinite.SpringBootMvc.model.Customer;
public interface ICustomerDao {
	public List<Customer> getAllCustomers() ;
	public Customer getCustomer(int id) ;
	public Customer addCustomer(Customer customer);
	public void updateCustomer(Customer customer) ;
	public void deleteCustomer(int id) ;

}
