package com.example.demoVentas.infrastructure.exception;

public class NotFoundException extends RuntimeException{
	private static final long serialVersionUID = 3L;
	
	public NotFoundException(String ms) {
		super(ms);
	}
}
