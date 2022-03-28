package com.capgemini.cab.management.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.cab.management.application.domain.Cab;

public interface CabRepository extends JpaRepository<Cab, Long>{

	@Query("select c from Cab c where c.carType=?1")
	Cab getCabByType(String cabType);
	
	@Query("select count(carType) from Cab c where c.carType=?1")
	int getCountByCabType(String cabType);
	
}
