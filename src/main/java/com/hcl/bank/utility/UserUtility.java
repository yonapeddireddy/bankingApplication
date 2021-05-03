package com.hcl.bank.utility;

public class UserUtility {
	private UserUtility() {
		throw new IllegalStateException("UserUtility class");
	}

	public static final String USER_EXISTS_ERROR = "User already exists!";
	public static final int USER_EXISTS_ERROR_STATUS = 605;

	public static final String USER_NOT_EXISTS_ERROR = "No User is Present!!";
	public static final int USER_NOT_EXISTS_STATUSCODE = 600;

}
