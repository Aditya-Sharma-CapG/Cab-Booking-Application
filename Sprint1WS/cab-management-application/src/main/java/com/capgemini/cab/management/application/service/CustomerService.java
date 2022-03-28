package com.capgemini.cab.management.application.service;

import java.util.List;

import com.capgemini.cab.management.application.domain.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerById(long id);
	Customer updateCustomer(Customer customer,long id);
	void deleteCustomer(long id);

	

	

}
