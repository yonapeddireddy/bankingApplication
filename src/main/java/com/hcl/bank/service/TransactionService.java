package com.hcl.bank.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.bank.dto.FullStatementDto;
import com.hcl.bank.dto.TransactionDTO;
import com.hcl.bank.exception.AccountNumberNotFoundException;
import com.hcl.bank.exception.BalanceInsufficientException;
import com.hcl.bank.exception.NoTransactionsException;
import com.hcl.bank.exception.SameAccountNumberException;
import com.hcl.bank.exception.ZeroBalanceException;
import com.hcl.bank.model.Account;
import com.hcl.bank.model.SmsRequest;
import com.hcl.bank.model.Transaction;
import com.hcl.bank.model.User;
import com.hcl.bank.repositry.AccountRepositry;
import com.hcl.bank.repositry.TransactionRepositry;
import com.hcl.bank.repositry.UserRepositry;
import com.hcl.bank.utility.AccountUtility;
import com.hcl.bank.utility.TransactionUtility;

@Service
public class TransactionService {
	@Autowired
	TransactionRepositry transactionRepositry;
	@Autowired
	AccountRepositry accountRepositry;
	@Autowired
	UserRepositry userRepositry;
	static String USername;
	@Autowired
	SmsSender smssender;

	public TransactionService(String userName) {
		USername = userName;
	}

	public boolean saveTransaction(TransactionDTO transactionDto) throws BalanceInsufficientException,
			AccountNumberNotFoundException, SameAccountNumberException, ZeroBalanceException {
		Transaction transaction = new Transaction();
		Account account = new Account();
		Long transferAmount = transactionDto.getAmount();
		Long fromAccount = transactionDto.getFromAccount();
		System.out.println(fromAccount);
		TransactionService username = new TransactionService(USername);
		User user = userRepositry.findByUsername(USername);
		Integer userid = user.getUserId();
		Long phnno = user.getPhonenumber();
		String phn = Long.toString(phnno);
		String message = "Your Account is debited with amount of Rs: " + transferAmount;
		Account AccountNumber = accountRepositry.findByUserid(userid);
		Long accountNumber = AccountNumber.getAccountNumber();
		if (!fromAccount.equals(accountNumber)) {
			throw new AccountNumberNotFoundException(AccountUtility.FROM_ACCOUNT_NUMBER_ERROR);

		}

		LocalDate date = LocalDate.now();

		Long toAccount = transactionDto.getToAccount();

		Account fromAccountNumber = accountRepositry.findByAccountNumber(fromAccount);

		Account toAccountnumber = accountRepositry.findByAccountNumber(toAccount);

		if (ObjectUtils.isEmpty(fromAccountNumber) || ObjectUtils.isEmpty(toAccountnumber)) {
			throw new AccountNumberNotFoundException(AccountUtility.ACCOUNT_NUMBER_NOT_EXISTS_ERROR);
		}

		if (fromAccountNumber.equals(toAccountnumber)) {
			throw new SameAccountNumberException(AccountUtility.SAME_ACCOUNT_NUMBER_ERROR);
		}
		List<Transaction> transactions = transactionRepositry.findByFromAccountAndDateOfTransaction(fromAccount,
				date.getMonthValue());
		Long frombalance = fromAccountNumber.getBalance();

		if (ObjectUtils.isEmpty(fromAccountNumber) || ObjectUtils.isEmpty(toAccountnumber)) {
			throw new AccountNumberNotFoundException(AccountUtility.ACCOUNT_NUMBER_NOT_EXISTS_ERROR);
		}
		if (transferAmount <= 0) {
			throw new ZeroBalanceException(TransactionUtility.BALANCE_GREATER_THAN_ZERO_ERROR);

		}
		if (frombalance < transferAmount) {
			throw new BalanceInsufficientException(TransactionUtility.BALANCE_INSUFFICIENT_ERROR);

		} else {

			if (transactions.size() >= 10)
				fromAccountNumber.setBalance(frombalance - transferAmount - 10);
			else
				fromAccountNumber.setBalance(frombalance - transferAmount);

			Long tobalance = toAccountnumber.getBalance();

			toAccountnumber.setBalance(transferAmount + tobalance);
			LocalDate today = LocalDate.now();
			transaction.setDateOfTransaction(today);
			transactionDto.setType("Debit");
			BeanUtils.copyProperties(transactionDto, transaction);

			transactionRepositry.save(transaction);
			SmsRequest req = new SmsRequest(phn, message);
			smssender.sendSms(req);
			return true;

		}
	}

	public TransactionService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Transaction> transactionList(TransactionDTO transactionDto)
			throws NoTransactionsException, AccountNumberNotFoundException {
		Long accountNumber = transactionDto.getFromAccount();
		int date = transactionDto.getDate().getMonth();
		System.out.println(USername);
		TransactionService username = new TransactionService(USername);

		System.out.println(USername);
		User user = userRepositry.findByUsername(USername);
		Integer userid = user.getUserId();
		Account account = accountRepositry.findByUserid(userid);
		Long fromAccountNumber = account.getAccountNumber();
		if (!accountNumber.equals(fromAccountNumber)) {
			throw new AccountNumberNotFoundException(AccountUtility.FROM_ACCOUNT_NUMBER_ERROR);

		}
		Account accountnumber = accountRepositry.findByAccountNumber(accountNumber);
		if (ObjectUtils.isEmpty(accountnumber)) {
			throw new AccountNumberNotFoundException(AccountUtility.ACCOUNT_NUMBER_NOT_EXISTS_ERROR);

		}
		Pageable pagable = PageRequest.of(0, 5, Sort.by("transactionId").descending());
		List<Transaction> transactions = transactionRepositry.findByFromAccountAndDateOfTransaction(accountNumber,
				date + 1, pagable);
		if (transactions.isEmpty()) {
			throw new NoTransactionsException(TransactionUtility.NO_TRANSACTION_DETAILS_ERROR);
		}
		return transactions;

		/*
		 * return transactions.stream().map(transaction -> { TransactionDTO
		 * transactionDTO = new TransactionDTO(); BeanUtils.copyProperties(transaction,
		 * transactionDTO); return transactionDTO; }).collect(Collectors.toList());
		 */

	}

	public List<Transaction> detailedtransactionList(FullStatementDto transactionDTO)
			throws NoTransactionsException, AccountNumberNotFoundException {
		Long accountNumber = transactionDTO.getFromAccount();
		TransactionService usernames = new TransactionService(USername);

		System.out.println(USername);
		User user = userRepositry.findByUsername(USername);
		Integer userid = user.getUserId();
		Account account = accountRepositry.findByUserid(userid);
		Long fromAccountNumber = account.getAccountNumber();
		if (!accountNumber.equals(fromAccountNumber)) {
			throw new AccountNumberNotFoundException(AccountUtility.FROM_ACCOUNT_NUMBER_ERROR);

		}
		System.out.println(accountNumber);
		Date fromdate = transactionDTO.getFromdate();
		Date todate = transactionDTO.getTodate();
		System.out.println(fromdate);
		System.out.println(todate);

		LocalDate FromDate = fromdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		LocalDate ToDate = todate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		System.out.println(ToDate);
		Account accountnumber = accountRepositry.findByAccountNumber(accountNumber);

		if (ObjectUtils.isEmpty(accountnumber)) {
			throw new AccountNumberNotFoundException(AccountUtility.ACCOUNT_NUMBER_NOT_EXISTS_ERROR);

		}
		List<Transaction> transactions = transactionRepositry
				.findByFromAccountAndDateOfTransactionBetween(accountNumber, FromDate, ToDate);
		if (transactions.isEmpty()) {
			throw new NoTransactionsException(TransactionUtility.NO_TRANSACTION_DETAILS_ERROR);
		}
		return transactions;

		/*
		 * return transactions.stream().map(transaction -> { Transaction transactiondto
		 * = new Transaction(); BeanUtils.copyProperties(transaction, transactiondto);
		 * return transactiondto; }).collect(Collectors.toList());
		 */

	}

}
