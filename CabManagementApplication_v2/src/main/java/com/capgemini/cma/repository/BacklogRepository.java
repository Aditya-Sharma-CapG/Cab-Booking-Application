package com.capgemini.cma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.cma.domain.Backlog;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {
	
	Backlog findByCabIdentifier(String cabIdentifier);
	
}
