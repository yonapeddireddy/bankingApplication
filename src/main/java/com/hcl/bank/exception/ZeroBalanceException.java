package com.hcl.bank.exception;

public class ZeroBalanceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public ZeroBalanceException(String message) {
		super(message);
	}
}
