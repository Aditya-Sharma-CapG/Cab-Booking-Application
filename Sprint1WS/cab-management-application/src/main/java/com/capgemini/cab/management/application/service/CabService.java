package com.capgemini.cab.management.application.service;

import java.util.List;

import com.capgemini.cab.management.application.domain.Cab;

public interface CabService {

	/*
	 * saveCab method is used to save the cab details in the database
	 * @param(Cab cab)
	 */
	Cab saveCab(Cab cab);
	
	/*
	 * getAllCabs method will show all the cab details
	 * returns list of cab details
	 */
	List<Cab> getAllCabs();
	
	/*
	 * getCabById shows the cab details with the id selected
	 * @param(id)
	 */
	Cab getCabById(long id);
	
	/*
	 * getCabByType method show cab detail of the type specified
	 */
	Cab getCabByType(String cabType);
	
	/*
	 * updateCab method will update the cab type and its per km rate
	 * @param(cab, id)
	 */
	Cab updateCab(Cab cab, long id);
	
	/*
	 * this method will return the count of the cabs of specific type
	 */
	int countCabsOfType(String cabType);
	
	/*
	 * deleteCab method will delete the cab details based on specified id
	 * @param(id)
	 */
	void deleteCab(long id);
	
}
