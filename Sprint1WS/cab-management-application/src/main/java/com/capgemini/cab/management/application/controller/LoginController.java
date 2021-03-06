package com.capgemini.cab.management.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.cab.management.application.domain.Login;
import com.capgemini.cab.management.application.service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    
    private LoginService loginService;
    
    public LoginController(LoginService loginService) {
	super();
	this.loginService = loginService;
}

	// save login details API
    @PostMapping()
    public ResponseEntity<?> saveLogin(@Valid @RequestBody Login login, BindingResult result) {
    	
    	if (result.hasErrors()) {
			return new ResponseEntity<String>("Invalid login detail(s)", HttpStatus.BAD_REQUEST);
		}
    	
		return new ResponseEntity<Login>(loginService.saveLogin(login), HttpStatus.CREATED);
    }
    
    // get all login details API
    @GetMapping
    public List<Login> getAllLoginDetails() {
    	
    	return loginService.getAllLoginDetails();
    }
    
    // get user login details by user name
    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByName(@PathVariable("username") String username) {
    	
//    	if (result.hasErrors()) {
//			return new ResponseEntity<String>("Invalid username", HttpStatus.BAD_REQUEST);
//		}
    	
    	return new ResponseEntity<Login>(loginService.getUserByName(username), HttpStatus.OK);
    }
    
    // update user login details API
    @PutMapping("{username}")
    public ResponseEntity<?> updateUserLoginDetails(@Valid @PathVariable("username") String username, @RequestBody Login login, BindingResult result) {
    	
    	if (result.hasErrors()) {
			return new ResponseEntity<String>("Invalid login detail(s)", HttpStatus.BAD_REQUEST);
		}
    	
    	return new ResponseEntity<Login>(loginService.updateUserLoginDetails(login, username, username), HttpStatus.OK);
    }
    
    // delete a user login detail
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserLogin(@PathVariable("id") long id) {
    	
    	loginService.deleteUserLoginDetails(id);
    	
    	return new ResponseEntity<String>("Details deleted successfully!", HttpStatus.OK);
    }
    
 
}