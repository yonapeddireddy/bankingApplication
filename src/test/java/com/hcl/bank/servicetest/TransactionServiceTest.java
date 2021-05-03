package com.hcl.bank.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;

import com.hcl.bank.dto.TransactionDTO;
import com.hcl.bank.exception.AccountNumberNotFoundException;
import com.hcl.bank.exception.BalanceInsufficientException;
import com.hcl.bank.exception.NoTransactionsException;
import com.hcl.bank.exception.SameAccountNumberException;
import com.hcl.bank.exception.ZeroBalanceException;
import com.hcl.bank.model.Account;
import com.hcl.bank.model.Transaction;
import com.hcl.bank.model.User;
import com.hcl.bank.repositry.AccountRepositry;
import com.hcl.bank.repositry.TransactionRepositry;
import com.hcl.bank.repositry.UserRepositry;
import com.hcl.bank.service.TransactionService;

@RunWith(MockitoJUnitRunner.class)

public class TransactionServiceTest {
	@InjectMocks
	TransactionService transactionService;
	@Mock
	UserRepositry userRepositry;
	@Mock
	AccountRepositry accountRepositry;
	User user;
	@Mock
	TransactionRepositry transactionRepositry;
	Account account;
	Account account1;
	List<Transaction> transactions;
	Transaction transaction;
	TransactionDTO transactionDto;
	Transaction transaction1;
	static String username = "uday";

	@Before
	public void setup() {
		user = new User();
		user.setUsername(username);
		user.setCity("tnk");
		user.setEmail("abc@gmail.com");
		user.setFirstname("p");
		user.setLast_name("y");
		user.setPancard("abc");
		user.setPassword("mkj");
		user.setPhonenumber(995588);
		user.setState("ap");
		user.setUserId(1);
		transactionDto = new TransactionDTO();
		transactions = new ArrayList<>();

		transaction1 = new Transaction();
		Date date1 = new Date();
		transactionDto.setDate(date1);
		int date = transactionDto.getDate().getMonth();
		transaction1.setAmount(568L);
		transaction1.setDateOfTransaction(LocalDate.now());
		transaction1.setFromAccount(123654789L);
		transaction1.setToAccount(789654123L);
		transaction1.setTransactionId(1);
		transaction1.setType("debit");
		transactions.add(transaction1);
		transactionDto.setAmount(1000L);
		transactionDto.setFromAccount(123654789L);
		transactionDto.setToAccount(123965874L);
		transactionDto.setTransactionId(1);
		transactionDto.setType("debit");
		account = new Account();
		long acc1 = transactionDto.getFromAccount();
		long acc2 = transactionDto.getToAccount();
		account.setBalance(2000L);
		account.setAccountId(1);
		account.setAccountType("debit");
		account.setBranch("tnk");
		account.setUserid(1);
		account.setAccountNumber(acc1);
		account1 = new Account();
		account1.setAccountNumber(acc2);
		account1.setAccountId(9);
		account1.setAccountType("debit");
		account1.setBalance(11L);
		account1.setBranch("tnk");
		account1.setUserid(1);

		account.setUserid(1);
		/*
		 * System.out.println(account); System.out.println(account1)
		 */;
		/*
		 * LocalDate date2= LocalDate.now(); transaction.setAmount(568L);
		 * transaction.setDateOfTransaction(date1);
		 * transaction.setFromAccount(123654789L); transaction.setToAccount(789654123L);
		 * transaction.setTransactionId(1); transaction.setType("debit");
		 * System.out.println(transaction.getAmount());
		 */
		/*
		 * transaction.setToAccount(789654123L); transaction.setTransactionId(1);
		 * transaction.setType("debit"); transaction.setAmount(568L);
		 * transaction.setDateOfTransaction(date1);
		 * transaction.setFromAccount(123654789L); transactions.add(transaction);
		 */
	}

	@Test
	public void saveTransactionTest() throws BalanceInsufficientException, AccountNumberNotFoundException,
			SameAccountNumberException, ZeroBalanceException {
		// System.out.println(transaction.getAmount());
		// TransactionService t = new TransactionService(username);
		Mockito.when(userRepositry.findByUsername(Mockito.anyString())).thenReturn(user);
		Mockito.when(accountRepositry.findByUserid(Mockito.anyInt())).thenReturn(account);
		Mockito.when(accountRepositry.findByAccountNumber(Mockito.anyLong())).thenReturn(account1);
		Mockito.when(accountRepositry.findByAccountNumber(Mockito.anyLong())).thenReturn(account);
		System.out.println(account);
		System.out.println(account1);
		LocalDate date = LocalDate.now();
		Mockito.when(transactionRepositry.findByFromAccountAndDateOfTransaction(Mockito.anyLong(), Mockito.anyInt()))
				.thenReturn(transactions);
		Mockito.when(transactionRepositry.save(Mockito.any(Transaction.class))).thenReturn(null);

		boolean res = transactionService.saveTransaction(transactionDto);
		assertEquals(true, res);
	}

	@Test(expected = AccountNumberNotFoundException.class)
	public void AccountNumberNotFoundException() throws com.hcl.bank.exception.AccountNumberNotFoundException,
			BalanceInsufficientException, SameAccountNumberException, ZeroBalanceException {

		Mockito.when(userRepositry.findByUsername(Mockito.anyString())).thenReturn(user);
		Mockito.when(accountRepositry.findByUserid(Mockito.anyInt())).thenReturn(account);
		transactionService.saveTransaction(transactionDto);
	}

	@Test
	public void transactionListTest()
			throws NoTransactionsException, com.hcl.bank.exception.AccountNumberNotFoundException {
		System.out.println(user);
		int date = LocalDate.now().getMonthValue();
		Mockito.when(userRepositry.findByUsername(Mockito.anyString())).thenReturn(user);
		Mockito.when(accountRepositry.findByUserid(Mockito.anyInt())).thenReturn(account);
		Mockito.when(accountRepositry.findByAccountNumber(Mockito.anyLong())).thenReturn(account);
		Mockito.when(transactionRepositry.findByFromAccountAndDateOfTransaction(Mockito.anyLong(), Mockito.anyInt(),
				Mockito.any(Pageable.class))).thenReturn(transactions);
		List<Transaction> trans = transactionService.transactionList(transactionDto);
		System.out.println(trans.size());
		assertEquals(transactions.size(), trans.size());
	}
}
