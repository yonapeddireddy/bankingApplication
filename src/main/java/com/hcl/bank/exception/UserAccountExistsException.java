package com.hcl.bank.exception;

public class UserAccountExistsException extends Exception {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public UserAccountExistsException(String message) {
	super(message);
}
}
