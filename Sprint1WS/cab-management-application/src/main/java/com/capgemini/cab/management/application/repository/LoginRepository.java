package com.capgemini.cab.management.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.cab.management.application.domain.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	
	/*
	 * This findByUsernameAndPassword method is used to check for valid user login details
	 * will remain on the login page till valid login details provided
	 * @param (username, password)
	 */
//	Login findByUsernameAndPassword(String user name, String password);
	
	//////////////////////////////////////////////////
	
	/*
	 * This method will fetch the user details based on the name specified
	 * @param (user name)
	 */
	@Query("select l from Login l where l.username=?1")
	Login findByUsername(String username);
 
}
