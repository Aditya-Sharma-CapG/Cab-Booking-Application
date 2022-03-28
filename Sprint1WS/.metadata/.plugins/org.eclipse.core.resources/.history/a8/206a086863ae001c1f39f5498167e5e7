package com.capgemini.cab.management.application.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * The login class is kept as Entity to display in db
 * table name is login
 */
@Entity
@Table(name = "login")
public class Login {

	/*
	 * Id is the primary key
	 * not null
	 * auto generated
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * username will be asked on login page to authenticate
	 */
	private String username;
	
	/*
	 * password will be asked on login page to authenticate
	 */
	private String password;
	
	// default constructor
	public Login() {
		
	}
	
	// parameterized constructor
	public Login(Long id, String username, String password) {
		
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	// Getters and Setters
	
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
}
