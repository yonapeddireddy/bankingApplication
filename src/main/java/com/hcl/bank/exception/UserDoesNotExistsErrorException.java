package com.hcl.bank.exception;

public class UserDoesNotExistsErrorException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public UserDoesNotExistsErrorException(String message) {
		super(message);
	}
}
