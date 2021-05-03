package com.hcl.bank.exception;

public class AccountCreationException extends Exception {

	private static final long serialVersionUID = 1L;
	String message;

	public AccountCreationException(String message) {
		super(message);

	}
}
