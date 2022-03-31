package com.capgemini.cab.management.application.serviceimpl;



import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class MapValidationErrorService {

	public ResponseEntity<?> mapValidationError(BindingResult result) {
		if(result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();  // creating a map to store error name and message
			
			for(FieldError fieldError : result.getFieldErrors()) {
				
				errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());  // storing the field name (such as projectName) and the default message (such as "project name is required")
				
			}
			return new ResponseEntity<Map<String, String>> (errorMap, HttpStatus.BAD_REQUEST);  // this map will display the specific errors in the rest client stored in errorMap
		}
		return null;
	}
	
}
