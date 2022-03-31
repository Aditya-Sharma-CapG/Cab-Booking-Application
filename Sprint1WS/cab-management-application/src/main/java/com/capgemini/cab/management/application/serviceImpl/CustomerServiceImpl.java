package com.capgemini.cab.management.application.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.cab.management.application.domain.Customer;
import com.capgemini.cab.management.application.exception.CustomerResourceNotFoundExeption;
import com.capgemini.cab.management.application.repository.CustomerRepository;
import com.capgemini.cab.management.application.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	private CustomerRepository customerRepository;
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	@Override
	public Customer saveCustomer(Customer customer) {
	return customerRepository.save(customer);
	}
	@Override
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}
	@Override
	public Customer getCustomerById(long id) {
		//Optional<Customer> customer =customerRepository.findById(id);
		return customerRepository.findById(id).orElseThrow(()-> new CustomerResourceNotFoundExeption("Customer","Id",id));
	}
	
	@Override
	public Customer updateCustomer(Customer customer, long id) {
		//we need to check whether customer with given id is existing in DB or not
		Customer existingCustomer=customerRepository.findById(id).orElseThrow(()->new CustomerResourceNotFoundExeption("Customer","Id",id));
		existingCustomer.setUsername(customer.getUsername());
		existingCustomer.setPassword(customer.getPassword());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setMobileNumber(customer.getMobilenumber());
		//save existing customer in DB
		customerRepository.save(existingCustomer);
		
		
		
		return existingCustomer;
	}
	@Override
	public void deleteCustomer(long id) {
		//check weather a customer exist in DB or not
		customerRepository.findById(id).orElseThrow(() ->new CustomerResourceNotFoundExeption("Customer","Id",id));
		customerRepository.deleteById(id);
		
	}

}
