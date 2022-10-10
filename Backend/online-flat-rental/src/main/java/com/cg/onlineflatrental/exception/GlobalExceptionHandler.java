package com.cg.onlineflatrental.exception;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value= TenantNotFoundException.class)
	public ResponseEntity<String>tenantNotFoundException(TenantNotFoundException tenantNotFoundException){
		return new ResponseEntity<String>("Tenant not found, Try with another Tenant Id", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=FlatBookingNotFoundException.class)
	public ResponseEntity<String> handleLandlordNotFoundException(FlatBookingNotFoundException exe)
	{
		return new ResponseEntity<String>("no flat booking found.",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = FlatNotFoundException.class)
	public ResponseEntity<String> flatNotFoundException(FlatNotFoundException flatNotFoundException){
		return new ResponseEntity<String>("Flat you want not exists in db. Please try again",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value= LandlordNotFoundException.class)
	public ResponseEntity<String> landlordNotFoundException(LandlordNotFoundException e){
		return new ResponseEntity<String>("Landlord Not found", HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException exe)
	{
		return new ResponseEntity<String>("no flat booking found.",HttpStatus.NOT_FOUND);
	}


}

