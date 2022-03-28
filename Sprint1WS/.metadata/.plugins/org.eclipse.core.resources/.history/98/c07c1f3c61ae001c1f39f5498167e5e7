package com.capgemini.cab.management.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.cab.management.application.domain.Login;
import com.capgemini.cab.management.application.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;
	
	/*
	 * This login method asks for username and password to check the login details in repo, if not valid, then page remains unlogged
	 * @param (username, password)
	 * 
	 */
	  public Login login(String username, String password) {
		  Login user = repo.findByUsernameAndPassword(username, password);
		   return user;
	  }
	  
}
