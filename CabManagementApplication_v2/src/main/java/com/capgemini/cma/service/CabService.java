package com.capgemini.cma.service;

import com.capgemini.cma.domain.Cab;

public interface CabService {

	/*
	 * saveCab method is used to save the cab details in the database
	 * @param(Cab cab)
	 */
//	Cab saveCab(Cab cab);
	public Cab saveOrUpdate(Cab cab);
	
	/*
	 * getAllCabs method will show all the cab details
	 * returns list of cab details
	 */
//	public List<Cab> getAllCabs();
	public Iterable<Cab> findAllCab();
	
	/*
	 * getCabById shows the cab details with the id selected
	 * @param(id)
	 */
//	public Cab getCabById(long id);
	
	/*
	 * getCabByType method show cab detail of the type specified
	 */
//	public Cab getCabByType(String cabType);
	public Cab findCabByCabIdentifier(String cabId);
	
	/*
	 * updateCab method will update the cab type and its per km rate
	 * @param(cab, id)
	 */
//	Cab updateCab(Cab cab, long id);
	
	/*
	 * this method will return the count of the cabs of specific type
	 */
//	public int countCabsOfType(String cabType);
	
	/*
	 * deleteCab method will delete the cab details based on specified id
	 * @param(id)
	 */
	
//	public void deleteCab(long id);
	public void deleteCabByCabIdentifier(String cabId);
	
}
