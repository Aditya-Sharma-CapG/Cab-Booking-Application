package com.capgemini.cab.management.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.cab.management.application.domain.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	
	/*
	 * This findByUsernameAndPassword method is used to check for valid user login details
	 * will remain on the login page till valid login details provided
	 * @param (username, password)
	 */
	Login findByUsernameAndPassword(String username, String password);
 
}
