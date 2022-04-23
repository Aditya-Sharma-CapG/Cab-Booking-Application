package com.capgemini.cma.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.cma.domain.CabTask;
import com.capgemini.cma.service.CabTaskService;
import com.capgemini.cma.serviceImpl.MapValidationErrorService;

@RestController
@RequestMapping("/api/backlog")
public class CabBacklogController {

	@Autowired
	private CabTaskService cabTaskService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("/{backlog_id}")
	public ResponseEntity<?> addPTtoBacklog(@Valid @RequestBody CabTask cabTask, BindingResult result, 
			@PathVariable String backlog_id ) {
		
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		
		if(errorMap != null) {
			return errorMap;
		}
		
		CabTask createdCabTask = cabTaskService.addCabTask(backlog_id, cabTask);
		
		return new ResponseEntity<CabTask>(createdCabTask, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{backlog_id}/{ct_id}")
	public ResponseEntity<?> getCabTask(@PathVariable String backlog_id, @PathVariable String ct_id) {
		CabTask cabTask = cabTaskService.findCabTaskByCabSequence(backlog_id, ct_id);
		
		return new ResponseEntity<CabTask>(cabTask, HttpStatus.OK);
	}
	
	@DeleteMapping("/{backlog_id}/{ct_id}")
	public ResponseEntity<?> deleteCabTask(@PathVariable String backlog_id, @PathVariable String ct_id) {
		cabTaskService.deleteCTByCabTaskSequence(backlog_id, ct_id);
		
		return new ResponseEntity<String>("Cab Task " + ct_id + " deleted successfully!", HttpStatus.OK);
	}
	
	@PatchMapping("/{backlog_id}/{ct_id}")
	public ResponseEntity<?> updateCabTask(@RequestBody CabTask updatedCabTask, @PathVariable String backlog_id, @PathVariable String ct_id, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
				
		if (errorMap != null) {
			return errorMap;
		}
		
		CabTask updatedCabsTask = cabTaskService.updateByCabTaskSeqence(updatedCabTask, backlog_id, ct_id);
		
		return new ResponseEntity<CabTask>(updatedCabsTask, HttpStatus.OK);
	}
	
}
