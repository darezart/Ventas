package com.example.demoVentas.infrastructure.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionUserHelper {
	
	@ExceptionHandler(value = {NotFoundException.class})
	public ResponseEntity<Object> handleNotFoundException(NotFoundException e){
		ErrorResponse er = new ErrorResponse();
		er.setTimestamp(Instant.now().toEpochMilli());
		er.setStatus(404);
		er.setMessage(e.getMessage().toUpperCase().replace(" ", "_"));
		er.setError(e.getMessage());
		er.setPath("/products");
		
		return new ResponseEntity<Object>(er, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {AlreadyExistsException.class})
	public ResponseEntity<Object> handleAlreadyExistsException(AlreadyExistsException e){
		ErrorResponse er = new ErrorResponse();
		er.setTimestamp(Instant.now().toEpochMilli());
		er.setStatus(400);
		er.setMessage(e.getMessage().toUpperCase().replace(" ", "_"));
		er.setError("Bad Request");
		er.setPath("/products");
		
		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}
}
