package com.hcl.bank.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bank.dto.UserAccountDetailsDTO;
import com.hcl.bank.exception.AccountNumberNotFoundException;
import com.hcl.bank.exception.UserDoesNotExistsErrorException;
import com.hcl.bank.model.Account;
import com.hcl.bank.model.User;
import com.hcl.bank.repositry.AccountRepositry;
import com.hcl.bank.repositry.UserRepositry;
import com.hcl.bank.service.UserService;

@RunWith(MockitoJUnitRunner.class)

public class UserServiceTest {
	@InjectMocks
	UserService userService;
	@Mock
	UserRepositry userRepositry;
	@Mock
	AccountRepositry accountRepositry;
	User user;
	Account account;
	UserAccountDetailsDTO userAccounDetailsDto;

	@Before
	public void setup() {
		user = new User();
		user.setUsername("yona");
		user.setCity("tnk");
		user.setEmail("abc@gmail.com");
		user.setFirstname("p");
		user.setLast_name("y");
		user.setPancard("abc");
		user.setPassword("mkj");
		user.setPhonenumber(995588);
		user.setState("ap");
		user.setUserId(1);
		account = new Account();
		account.setBalance(2000L);
		account.setAccountId(1);
		account.setAccountType("debit");
		account.setBranch("tnk");
		account.setUserid(1);
		account.setAccountNumber(123654789L);
		userAccounDetailsDto = new UserAccountDetailsDTO();
		userAccounDetailsDto.setUser(user);
		userAccounDetailsDto.setAccount(account);
	}

	@Test
	public void searchTest() throws UserDoesNotExistsErrorException, AccountNumberNotFoundException {
		Mockito.when(userRepositry.findByUsername(Mockito.anyString())).thenReturn(user);
		Mockito.when(accountRepositry.findByUserid(Mockito.anyInt())).thenReturn(account);
		Mockito.when(accountRepositry.findByAccountNumber(Mockito.anyLong())).thenReturn(account);
		Mockito.when(userRepositry.findByUserId(Mockito.anyInt())).thenReturn(user);
		UserAccountDetailsDTO userAccounts = userService.search(user.getUsername(), account.getAccountNumber());
		assertEquals(userAccounts.getAccount(), userAccounDetailsDto.getAccount());
	}

	@Test(expected = UserDoesNotExistsErrorException.class)
	public void UserNotExitsTest() throws UserDoesNotExistsErrorException, AccountNumberNotFoundException {
		Mockito.when(userRepositry.findByUsername(Mockito.anyString())).thenReturn(user);
		userService.search(user.getUsername(), account.getAccountNumber());
	}
}
