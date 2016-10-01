package com.myretail.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jayway.jsonpath.PathNotFoundException;
import com.myretail.exceptionhandling.Error;

public class BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@ExceptionHandler(PathNotFoundException.class)
	public ResponseEntity<Error> handle(PathNotFoundException ex,HttpServletRequest req){
		logger.info("controller local exception handling @ExceptionHandler");
		Error error = new Error();
		error.setTimestamp((new Date()).getTime());
		error.setException(ex.getClass().toString());
		error.setMessage("Not valid product in system: This product ID does not represent a valid product");
		error.setError(ex.getMessage());
		error.setPath(req.getRequestURI());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Error> handle(NullPointerException ex){
		logger.info("controller local exception handling @ExceptionHandler");
		Error error = new Error();
		return new ResponseEntity<Error>(error, HttpStatus.NO_CONTENT);
	}
	

}
