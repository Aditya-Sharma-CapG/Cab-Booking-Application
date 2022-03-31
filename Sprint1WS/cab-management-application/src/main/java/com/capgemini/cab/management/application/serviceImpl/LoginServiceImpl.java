package com.capgemini.cab.management.application.serviceimpl;


 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.cab.management.application.domain.Login;
import com.capgemini.cab.management.application.repository.LoginRepository;
import com.capgemini.cab.management.application.service.LoginService;
 
/*
 * This class checks if login details entered are correct or not
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository repo;
  
	public Login login(String username, String password) {
		Login user = repo.findByUsernameAndPassword(username, password);
		return user;
	  }
}
