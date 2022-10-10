package com.cg.onlineflatrental.exception;

public class FlatBookingNotFoundException extends Exception {
	String msg;
	public FlatBookingNotFoundException(String msg) {
		super();
		this.msg=msg;
	}
	public FlatBookingNotFoundException() {
		super();
	}

}
