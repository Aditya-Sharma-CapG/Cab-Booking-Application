package com.capgemini.cab.management.application.serviceImpl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.cab.management.application.domain.Login;
import com.capgemini.cab.management.application.repository.LoginRepository;
import com.capgemini.cab.management.application.service.LoginService;
 
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository repo;
  
	public Login login(String username, String password) {
		Login user = repo.findByUsernameAndPassword(username, password);
		return user;
	  }
}
