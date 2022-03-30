package com.capgemini.cab.management.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.cab.management.application.domain.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking,Integer> {

	//TODO : No need to add CRUD operations over here , if any customization is required we can customize the CRUD methods.
}
