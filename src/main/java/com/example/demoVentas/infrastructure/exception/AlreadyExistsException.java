package com.example.demoVentas.infrastructure.exception;

public class AlreadyExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public AlreadyExistsException(String ms) {
		super(ms);
	}
}
