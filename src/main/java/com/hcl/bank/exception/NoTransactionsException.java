package com.hcl.bank.exception;

public class NoTransactionsException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoTransactionsException(String message) {
		super(message);
	}
}
