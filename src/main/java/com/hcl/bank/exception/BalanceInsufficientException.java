package com.hcl.bank.exception;

public class BalanceInsufficientException extends Exception {

	private static final long serialVersionUID = 1L;

public BalanceInsufficientException(String message) {
	super(message);
}
}
