package com.capgemini.cma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CabIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CabIdException() {
		super();
	}
	
	public CabIdException(String errMsg) {
		super(errMsg);
	}
}
