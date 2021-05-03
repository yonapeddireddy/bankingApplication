package com.hcl.bank.exception;

public class FromNumberNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public FromNumberNotFoundException(String message) {
		super(message);
	}
}
