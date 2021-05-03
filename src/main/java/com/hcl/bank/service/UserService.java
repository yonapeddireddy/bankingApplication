package com.hcl.bank.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.bank.dto.AccountDTO;
import com.hcl.bank.dto.UserAccountDetailsDTO;
import com.hcl.bank.dto.UserDTO;
import com.hcl.bank.exception.AccountNumberNotFoundException;
import com.hcl.bank.exception.AdminDoesNotExistsException;
import com.hcl.bank.exception.UserDoesNotExistsErrorException;
import com.hcl.bank.exception.UserExistsException;
import com.hcl.bank.model.Account;
import com.hcl.bank.model.Admin;
import com.hcl.bank.model.User;
import com.hcl.bank.repositry.AccountRepositry;
import com.hcl.bank.repositry.UserRepositry;
import com.hcl.bank.utility.AccountUtility;
import com.hcl.bank.utility.AdminUtility;
import com.hcl.bank.utility.UserUtility;

@Service
public class UserService {
	@Autowired
	UserRepositry userRepositry;
	@Autowired
	AccountRepositry accountRepositry;

	public boolean saveUser(UserDTO userDto) throws UserExistsException {
		User users = new User();
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		while (salt.length() < 8) { // length of the random string.
			int index = (int) (Math.random() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		userDto.setPassword(saltStr);
		String username = userDto.getUsername();

		User user = userRepositry.findByUsername(username);
		if (ObjectUtils.isEmpty(user)) {
			System.out.println(userDto);

			BeanUtils.copyProperties(userDto, users);
			userRepositry.save(users);
			return true;
		} else {
			throw new UserExistsException(UserUtility.USER_EXISTS_ERROR);
		}
	}

	public boolean updatePassword(UserDTO userdto) throws UserDoesNotExistsErrorException {
		User user = new User();
		Integer userid = userdto.getUserId();
		String password = userdto.getPassword();
		User user_id = userRepositry.findByUserId(userid);
		if (ObjectUtils.isEmpty(user_id)) {
			throw new UserDoesNotExistsErrorException(UserUtility.USER_NOT_EXISTS_ERROR);

		} else {
			Integer userId = user_id.getUserId();
			user_id.setPassword(password);
			userRepositry.save(user_id);
		}
		return true;
	}

	@SuppressWarnings("unused")
	public UserAccountDetailsDTO search(String username, @RequestParam Long accountno)
			throws UserDoesNotExistsErrorException, AccountNumberNotFoundException {

		if ((accountno == null)) {
			UserAccountDetailsDTO userAccountDetailsDTO = new UserAccountDetailsDTO();
			User userDetails = userRepositry.findByUsername(username);
			System.out.println(userDetails);
			if (ObjectUtils.isEmpty(userDetails)) {
				throw new UserDoesNotExistsErrorException(UserUtility.USER_NOT_EXISTS_ERROR);

			}
			Integer userid = userDetails.getUserId();
			Account accountDetails = accountRepositry.findByUserid(userid);
			if (ObjectUtils.isEmpty(accountDetails)) {
				throw new AccountNumberNotFoundException(UserUtility.USER_NOT_EXISTS_ERROR);

			}
			userAccountDetailsDTO.setUser(userDetails);
			userAccountDetailsDTO.setAccount(accountDetails);

			return userAccountDetailsDTO;
		} else {
			UserAccountDetailsDTO userAccountDetailsDTO = new UserAccountDetailsDTO();
			Account account = accountRepositry.findByAccountNumber(accountno);
			if (ObjectUtils.isEmpty(account)) {
				throw new UserDoesNotExistsErrorException(UserUtility.USER_NOT_EXISTS_ERROR);

			}
			Integer userid = account.getUserid();
			User userDetails = userRepositry.findByUserId(userid);
			if (ObjectUtils.isEmpty(userDetails)) {
				throw new AccountNumberNotFoundException(AccountUtility.ACCOUNT_NUMBER_NOT_EXISTS_ERROR);

			}

			userAccountDetailsDTO.setUser(userDetails);
			userAccountDetailsDTO.setAccount(account);

			return userAccountDetailsDTO;
		}
	}

	public boolean login(@Valid String username, String password) throws UserDoesNotExistsErrorException {
		User user = userRepositry.findByUsernameAndPassword(username, password);
		if (!ObjectUtils.isEmpty(user))
			return true;
		else
			throw new UserDoesNotExistsErrorException(UserUtility.USER_NOT_EXISTS_ERROR);
	}
}
