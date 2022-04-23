package com.capgemini.cma.service;

import java.util.List;

import com.capgemini.cma.domain.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerById(long id);
	Customer updateCustomer(Customer customer,long id);
	void deleteCustomer(long id);

	

	

}
