package com.hcl.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.bank.utility.AccountUtility;
import com.hcl.bank.utility.AdminUtility;
import com.hcl.bank.utility.TransactionUtility;
import com.hcl.bank.utility.UserUtility;


@ControllerAdvice
public class GloableException extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UserExistsException.class)
	public ResponseEntity<ErrorResponse> UserExitsException(UserExistsException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(UserUtility.USER_EXISTS_ERROR_STATUS);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserDoesNotExistsErrorException.class)
	public ResponseEntity<ErrorResponse> UserDoesNotExitsException(UserDoesNotExistsErrorException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(UserUtility.USER_NOT_EXISTS_STATUSCODE);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdminDoesNotExistsException.class)
	public ResponseEntity<ErrorResponse> AdminDoesNotException(AdminDoesNotExistsException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(AdminUtility.ADMIN_DOESNOT_EXISTS_ERROR_STATUS);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AccountCreationException.class)
	public ResponseEntity<ErrorResponse> AcoountCreation(AccountCreationException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(AccountUtility.ACCOUNT_CREATION_ERROR_STATUS);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserAccountExistsException.class)
	public ResponseEntity<ErrorResponse> UserAccountExistsException(UserAccountExistsException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(AccountUtility.USER_EXISTS_ACCOUNT_ERROR_STATUSCODE);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BalanceInsufficientException.class)
	public ResponseEntity<ErrorResponse> BalanceInsufficientException(BalanceInsufficientException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(TransactionUtility.BALANCE_INSUFFICIENT_ERROR_STATUS);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoTransactionsException.class)
	public ResponseEntity<ErrorResponse> NoTransactionsException(NoTransactionsException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(TransactionUtility.NO_TRANSACTION_DETAILS_ERROR_STATUSCODE);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SameAccountNumberException.class)
	public ResponseEntity<ErrorResponse> SameAccountNumberException(SameAccountNumberException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(AccountUtility.ACCOUNT_NUMBER_NOT_EXISTS_ERROR_STATUSCODE);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(AccountNumberNotFoundException.class)
	public ResponseEntity<ErrorResponse> AccountNumberNotFoundException(AccountNumberNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(AccountUtility.SAME_ACCOUNT_NUMBER_ERROR_STATUSCODE);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FromNumberNotFoundException.class)
	public ResponseEntity<ErrorResponse> FromNumberNotFoundException(FromNumberNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(AccountUtility.FROM_ACCOUNT_NUMBER_ERROR_STATUSCODE);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ZeroBalanceException.class)
	public ResponseEntity<ErrorResponse> ZeroBalance(ZeroBalanceException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(TransactionUtility.BALANCE_GREATER_THAN_ZERO_ERROR_STATUSCODE);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}