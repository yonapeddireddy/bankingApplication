package com.hcl.bank.utility;

public class TransactionUtility {
	private TransactionUtility() {
		throw new IllegalStateException("TransactionUtilty class");
	}

	public static final String BALANCE_INSUFFICIENT_ERROR = "Balance Is Insufficient";
	public static final int BALANCE_INSUFFICIENT_ERROR_STATUS = 606;
	public static final String NO_TRANSACTION_DETAILS_ERROR = "There are no transactions on the time you are searching for!!";
	public static final int NO_TRANSACTION_DETAILS_ERROR_STATUSCODE = 600;
	public static final String BALANCE_GREATER_THAN_ZERO_ERROR = "Provide some proper amount for fund Transfer";
	public static final int BALANCE_GREATER_THAN_ZERO_ERROR_STATUSCODE = 402;
}

