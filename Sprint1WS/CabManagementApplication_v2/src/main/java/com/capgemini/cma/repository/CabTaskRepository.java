package com.capgemini.cma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.cma.domain.CabTask;

@Repository
public interface CabTaskRepository extends CrudRepository<CabTask, Long> {
	
	CabTask findByCabTaskSequence(String cabSequence);

}
