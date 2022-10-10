package com.cg.onlineflatrental.exception;

public class TenantNotFoundException extends Exception {
	String msg;
	public TenantNotFoundException(String msg) {
		super();
		this.msg=msg;
	}
	public TenantNotFoundException() {
		super();
	}

}