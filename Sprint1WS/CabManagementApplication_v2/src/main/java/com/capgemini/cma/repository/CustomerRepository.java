package com.capgemini.cma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.cma.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	/**
	 * added crud operations
	 * insertCustomer
	 * updateCustomer
	 * deleteCustomer
	 * viewCustomer
	 * viewCustomerById
	 * 
	 */
}
