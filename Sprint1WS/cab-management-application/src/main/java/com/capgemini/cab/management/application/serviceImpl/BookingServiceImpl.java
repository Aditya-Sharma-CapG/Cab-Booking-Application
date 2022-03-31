package com.capgemini.cab.management.application.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.cab.management.application.domain.Booking;
import com.capgemini.cab.management.application.exception.BookingNotFoundException;
import com.capgemini.cab.management.application.repository.BookingRepository;
import com.capgemini.cab.management.application.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	private BookingRepository bookingRepository;
	
	 
	
	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}



	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}



	@Override
	public List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}



	@Override
	public Booking getBookingById(int id) {
		Optional<Booking> booking = bookingRepository.findById(id);
	    if(booking.isPresent())
	    {
	    	return booking.get();
	    }
	    else
	    {
	    	throw new BookingNotFoundException("Booking" ,"Id" ,id);
	    }
	}



	@Override
	public Booking updateBooking(Booking booking, int id) {
		// we need to check whether booking with given id exist in db or not.
		Booking existingBooking = bookingRepository.findById(id).orElseThrow(
				()-> new BookingNotFoundException("Booking" ,"Id" ,id));
		existingBooking.setCustomerId(booking.getCustomerId());
		existingBooking.setFromLocation(booking.getFromLocation());
		existingBooking.setToLocation(booking.getToLocation());
		existingBooking.setStatus(booking.getStatus());
		existingBooking.setDistanceInKm(booking.getDistanceInKm());
		existingBooking.setBill(booking.getBill());
		// save existing booking to db
		bookingRepository.save(existingBooking);
		return existingBooking;
	}



	@Override
	public void deleteBooking(int id) {
         bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException("Booking not exists with id ","Id" ,id));
		
		bookingRepository.deleteById(id);		
	}
	


}
