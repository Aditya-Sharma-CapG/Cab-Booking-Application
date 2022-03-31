package com.capgemini.cab.management.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.cab.management.application.domain.Booking;
import com.capgemini.cab.management.application.service.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
	private BookingService bookingservice;

	public BookingController(BookingService bookingservice) {
		super();
		this.bookingservice = bookingservice;
		}
	
	// build create employee REST API
	@PostMapping
	public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking)
	{
		return new ResponseEntity<Booking>(bookingservice.saveBooking(booking), HttpStatus.CREATED);
	}
	
	// build get all booking REST API
	@GetMapping
	public List<Booking> getAllBooking()
	{
		return bookingservice.getAllBooking();
	}
	
	// build get booking by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("id") int tripBookingId)
	{
		return new ResponseEntity<Booking>(bookingservice.getBookingById(tripBookingId),HttpStatus.OK);
	}
	
	// build update booking REST API
	@PutMapping("{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable("id") int id,@RequestBody Booking booking)
	{
		return new ResponseEntity<Booking>(bookingservice.updateBooking(booking,id),HttpStatus.OK);
	}
	
	// delete can REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCab(@PathVariable("id") int id) {
		bookingservice.deleteBooking(id);
		return new ResponseEntity<String>("Booking deleted successfully!", HttpStatus.OK);
	}
	
}
