package com.hcl.bank.dto;

import com.hcl.bank.model.Account;
import com.hcl.bank.model.User;

public class UserAccountDetailsDTO {
	private User user;
	private Account account;

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "UserAccountDetailsDTO [user=" + user + ", account=" + account + "]";
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
