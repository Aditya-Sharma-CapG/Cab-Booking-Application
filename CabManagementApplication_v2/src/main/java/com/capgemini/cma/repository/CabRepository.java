package com.capgemini.cma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.cma.domain.Cab;

@Repository
public interface CabRepository extends CrudRepository<Cab, Long>{

//	@Query("select c from Cab c where c.carType=?1")
//	Cab getCabByType(String cabType);
//	
//	@Query("select count(carType) from Cab c where c.carType=?1")
//	int getCountByCabType(String cabType);
	
	Cab findByCabIdentifier(String cabIdentifier);

	Iterable<Cab> findAll();
	
}
