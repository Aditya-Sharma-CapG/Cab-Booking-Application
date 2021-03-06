package com.capgemini.cab.management.application.controller;

import java.util.List;

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

import com.capgemini.cab.management.application.domain.Cab;
import com.capgemini.cab.management.application.service.CabService;

@RestController
@RequestMapping("/api/cabs")
public class CabController {

	private CabService cabService;

	public CabController(CabService cabService) {
		super();
		this.cabService = cabService;
	}
	
	// save cab API
	@PostMapping()
	public ResponseEntity<Cab> saveCab(@RequestBody Cab cab) {
		
		return new ResponseEntity<Cab>(cabService.saveCab(cab), HttpStatus.CREATED);
	}
	
	// get all cab details API
	@GetMapping
	public List<Cab> getAllCabs() {
		return cabService.getAllCabs();
	}
	
	// get a cab by car id
//	@GetMapping("{id}")
//	public ResponseEntity<Cab> getCabById(@PathVariable("id") long cabId) {
//		return new ResponseEntity<Cab>(cabService.getCabById(cabId), HttpStatus.OK);
//	}
	
	// get cab by car type
	@GetMapping("{carType}")
	public ResponseEntity<Cab> getCabByType(@PathVariable("carType") String cabType) {
		return new ResponseEntity<Cab>(cabService.getCabByType(cabType), HttpStatus.OK);
	}
	
	// get all cab counts by cabType
//	@GetMapping("/{carCount}")
//	public ResponseEntity<Integer> getCabCountByType(@PathVariable("carType") String carType) {
//		
//		return new ResponseEntity<Integer>(cabService.countCabsOfType(carType), HttpStatus.OK);
//		
//	}
	
	// update cab REST API
	@PutMapping("{id}")
	public ResponseEntity<Cab> updateCab(@PathVariable("id") long id, @RequestBody Cab cab) {
		
		return new ResponseEntity<Cab>(cabService.updateCab(cab, id), HttpStatus.OK);
	}

	// delete can REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCab(@PathVariable("id") long id) {
		cabService.deleteCab(id);
		
		return new ResponseEntity<String>("Cab deleted successfully!", HttpStatus.OK);
	}
}
