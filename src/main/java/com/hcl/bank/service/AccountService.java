package com.hcl.bank.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.bank.dto.AccountDTO;
import com.hcl.bank.dto.DepositAndWithdrawDto;
import com.hcl.bank.email.EmailSenderController;
import com.hcl.bank.exception.AccountCreationException;
import com.hcl.bank.exception.AccountNumberNotFoundException;
import com.hcl.bank.exception.BalanceInsufficientException;
import com.hcl.bank.exception.UserAccountExistsException;
import com.hcl.bank.exception.ZeroBalanceException;
import com.hcl.bank.model.Account;
import com.hcl.bank.model.SmsRequest;
import com.hcl.bank.model.User;
import com.hcl.bank.repositry.AccountRepositry;
import com.hcl.bank.repositry.UserRepositry;
import com.hcl.bank.utility.AccountUtility;
import com.hcl.bank.utility.TransactionUtility;

@Service
public class AccountService {
	@Autowired
	AccountRepositry accountRepositry;

	@Autowired
	UserRepositry userRepositry;
	@Autowired
	SmsSender smssender;

	public boolean createAccount(AccountDTO accountDto) throws UserAccountExistsException, AccountCreationException {
		Account account = new Account();

		Long accountnumber = (long) (Math.random() * 10000000000L);
		accountDto.setAccountNumber(accountnumber);

		Integer userid = accountDto.getUserid();

		User user_id = userRepositry.findByUserId(userid);
		if (ObjectUtils.isEmpty(user_id)) {
			throw new AccountCreationException(AccountUtility.ACCOUNT_CREATION_ERROR);
		}
		Integer user_Id = user_id.getUserId();
		Account account_userid = accountRepositry.findByUserid(user_Id);
		if (!ObjectUtils.isEmpty(account_userid)) {
			throw new UserAccountExistsException(AccountUtility.USER_ACCOUNT_EXISTS_ERROR);
		} else {
			Integer userId = user_id.getUserId();

			account.setUserid(userId);

			BeanUtils.copyProperties(accountDto, account);
			accountRepositry.save(account);

		}
		return true;
	}

	public boolean deposit(DepositAndWithdrawDto accountDto)
			throws AccountNumberNotFoundException, ZeroBalanceException {
		Long accountnumber = accountDto.getAccountNumber();

		Account account = accountRepositry.findByAccountNumber(accountnumber);
		Integer userid = account.getUserid();
		User user = userRepositry.findByUserId(userid);
		Long phnno = user.getPhonenumber();
		String phn = Long.toString(phnno);
		System.out.println(account);
		if (ObjectUtils.isEmpty(account)) {
			throw new AccountNumberNotFoundException(AccountUtility.ACCOUNT_NUMBER_NOT_EXISTS_ERROR);
		}
		Long currentBalance = account.getBalance();
		Long amount = accountDto.getAmount();
		String message = "Your Account is Credited with amount of Rs: " + amount;
		if (amount <= 0) {
			throw new ZeroBalanceException(TransactionUtility.BALANCE_GREATER_THAN_ZERO_ERROR);

		}
		account.setBalance(currentBalance + amount);
		accountRepositry.save(account);
		SmsRequest req = new SmsRequest(phn, message);
		smssender.sendSms(req);
		return true;
	}

	public boolean withdraw(@Valid DepositAndWithdrawDto accountDto)
			throws AccountNumberNotFoundException, BalanceInsufficientException, ZeroBalanceException {
		Long accountnumber = accountDto.getAccountNumber();

		Account account = accountRepositry.findByAccountNumber(accountnumber);
		Integer userid = account.getUserid();
		User user = userRepositry.findByUserId(userid);
		Long phnno = user.getPhonenumber();
		String phn = Long.toString(phnno);
		if (ObjectUtils.isEmpty(account)) {
			throw new AccountNumberNotFoundException(AccountUtility.ACCOUNT_NUMBER_NOT_EXISTS_ERROR);
		}
		Long currentBalance = account.getBalance();
		Long amount = accountDto.getAmount();
		String message = "Your Account is debited with amount of Rs: " + amount;
		if (amount <= 0) {
			throw new ZeroBalanceException(TransactionUtility.BALANCE_GREATER_THAN_ZERO_ERROR);

		}
		if (currentBalance < amount) {
			throw new BalanceInsufficientException(TransactionUtility.BALANCE_INSUFFICIENT_ERROR);

		}
		account.setBalance(currentBalance - amount);
		accountRepositry.save(account);
		SmsRequest req = new SmsRequest(phn, message);
		smssender.sendSms(req);
		return true;
	}

}
