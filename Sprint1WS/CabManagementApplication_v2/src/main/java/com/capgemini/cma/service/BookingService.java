package com.capgemini.cma.service;

import java.util.List;

import com.capgemini.cma.domain.Booking;

public interface BookingService {
	Booking saveBooking(Booking booking);
    List<Booking> getAllBooking();
    Booking getBookingById(int id);
    Booking updateBooking(Booking booking , int id);
	void deleteBooking(int id);

}
