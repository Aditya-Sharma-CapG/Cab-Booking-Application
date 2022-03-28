package com.capgemini.cab.management.application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.cab.management.application.domain.Customer;
import com.capgemini.cab.management.application.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	// build create/insert customer Rest API
	@PostMapping()
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
	return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
	}
	// build view all customers REST API
	@GetMapping
	public List<Customer>getAllCustomers(){
		return customerService.getAllCustomers();}
	
	//build view customers by id REST API
	@GetMapping("{id}")
	//http://localhost:8080/api/customers/1
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long customerId){
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId),HttpStatus.OK);
	}
	//build update customers REST API
	//http://localhost:8080/api/customers/1
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id")long id,@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id),HttpStatus.OK);
	
	}
	// build delete rest api
	//http://localhost:8080/api/customers/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id){
		//delete customer from DB
		customerService.deleteCustomer(id);
		return new ResponseEntity<String>("Customer deleted successfuly!.",HttpStatus.OK);
		}
}
