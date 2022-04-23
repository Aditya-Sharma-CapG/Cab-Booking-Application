package com.capgemini.cma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="UserName is Required") 
	@Column(name="username",nullable=false)
	private String username;
	@NotBlank(message="Password is Required") 
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="address",nullable=false)
	private String address;
	
	@Column(name="mobilenumber",nullable=false)
	private String mobilenumber;
	
	public Customer() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobileNumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String email;
 
}
