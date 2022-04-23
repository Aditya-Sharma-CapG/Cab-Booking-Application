package com.capgemini.cma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.cma.domain.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

	//TODO : No need to add CRUD operations over here , if any customization is required we can customize the CRUD methods.
}
