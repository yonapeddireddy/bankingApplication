package com.hcl.bank.utility;

public class AccountUtility {
	private AccountUtility() {
		throw new IllegalStateException("AccountUtilty class");
	}

	public static final String ACCOUNT_CREATION_ERROR = "No such User is Present for creating Account";
	public static final int ACCOUNT_CREATION_ERROR_STATUS = 606;
	public static final String USER_ACCOUNT_EXISTS_ERROR = "The User you want to create Account has Already Account!!";
	public static final int USER_EXISTS_ACCOUNT_ERROR_STATUSCODE = 600;
	public static final String ACCOUNT_NUMBER_NOT_EXISTS_ERROR = "No Account Numbers Found for Money Transfer!!";
	public static final int ACCOUNT_NUMBER_NOT_EXISTS_ERROR_STATUSCODE = 702;
	public static final String SAME_ACCOUNT_NUMBER_ERROR = "Can Not Transfer to same Account Numbers";
	public static final int SAME_ACCOUNT_NUMBER_ERROR_STATUSCODE = 404;
	public static final String FROM_ACCOUNT_NUMBER_ERROR = "You Should Mention Your Account Number";
	public static final int FROM_ACCOUNT_NUMBER_ERROR_STATUSCODE = 405;
}
