package com.cg.onlineflatrental.exception;

public class LandlordNotFoundException extends Exception {
	String msg;
	public LandlordNotFoundException(String msg) {
		super();
		this.msg=msg;
	}
	public LandlordNotFoundException() {
		super();
	}
}