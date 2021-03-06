package com.capgemini.cab.management.application.serviceImpl;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.cab.management.application.domain.Login;
import com.capgemini.cab.management.application.repository.LoginRepository;
import com.capgemini.cab.management.application.service.LoginService;
 
/*
 * This class checks if login details entered are correct or not
 */
@Service
public class LoginServiceImpl implements LoginService {

//	@Autowired
//	private LoginRepository repo;
//  
//	public Login login(String username, String password) {
//		Login user = repo.findByUsernameAndPassword(username, password);
//		return user;
//	  }
	
	////////////////////////////////////////////////////////////////////////////
	
	private LoginRepository loginRepository;

	public LoginServiceImpl(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}

	@Override
	public Login saveLogin(Login login) {
		return loginRepository.save(login);
	}

	@Override
	public List<Login> getAllLoginDetails() {
		return loginRepository.findAll();
	}

	@Override
	public Login getUserByName(String username) {
		
		@SuppressWarnings("unused")
		Login login = loginRepository.findByUsername(username);
		
		// exception handle
		
		return loginRepository.findByUsername(username);
	}

	@Override
	public Login updateUserLoginDetails(Login login, String username, String email) {
		
		Login existingLogin = loginRepository.findByUsername(username);
		
		if (existingLogin != null) {
			existingLogin.setUsername(login.getUsername());
			existingLogin.setPassword(login.getPassword());
			existingLogin.setEmail(login.getEmail());
		}
		
		loginRepository.save(existingLogin);
		
		return existingLogin;
	}

	@Override
	public void deleteUserLoginDetails(long id) {
		
		loginRepository.findById(id);

		loginRepository.deleteById(id);
	}
}
