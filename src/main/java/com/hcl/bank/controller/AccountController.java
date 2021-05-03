package com.hcl.bank.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.dto.AccountDTO;
import com.hcl.bank.dto.DepositAndWithdrawDto;
import com.hcl.bank.email.EmailSenderController;
import com.hcl.bank.exception.AccountCreationException;
import com.hcl.bank.exception.AccountNumberNotFoundException;
import com.hcl.bank.exception.BalanceInsufficientException;
import com.hcl.bank.exception.UserAccountExistsException;
import com.hcl.bank.exception.ZeroBalanceException;
import com.hcl.bank.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	AccountService accountService;

	@GetMapping("/accountdirection")
	public String accountGenerate(Map<String, Object> model) {
		model.put("accountsave", new AccountDTO());
		return "accountgenerate";
	}

	@PostMapping("/saveaccountdetails")
	public String generateAccount(@ModelAttribute("accountsave") @Valid AccountDTO accountDto)
			throws UserAccountExistsException, AccountCreationException {
		boolean response = accountService.createAccount(accountDto);
		if (response == true) {
			Integer userid=accountDto.getUserid();
			EmailSenderController email=new EmailSenderController(userid);
			
			return "redirect:/email";

		} else {
			return "accountgenerate";
		}
	}

	@GetMapping("/depositdirection")
	public String deposit(Map<String, Object> model) {
		model.put("deposit", new AccountDTO());
		return "deposit";
	}

	@PostMapping("/dpamount")
	public String depositIntoAccount(@ModelAttribute("deposit") DepositAndWithdrawDto accountDto)
			throws UserAccountExistsException, AccountCreationException, AccountNumberNotFoundException,
			ZeroBalanceException {
		System.out.println("hi");
		boolean response = accountService.deposit(accountDto);
		if (response == true) {
			return "depositsuccess";

		} else {
			return "deposit";
		}
	}

	@GetMapping("/withdrawdirection")
	public String withdraw(Map<String, Object> model) {
		model.put("withdraw", new AccountDTO());
		return "withdraw";
	}

	@PostMapping("/withdraw")
	public String withdrawFromAccount(@ModelAttribute("withdraw") @Valid DepositAndWithdrawDto accountDto)
			throws UserAccountExistsException, AccountCreationException, AccountNumberNotFoundException,
			BalanceInsufficientException, ZeroBalanceException {
		boolean response = accountService.withdraw(accountDto);
		if (response == true) {
			return "withdrawsuccess";

		} else {
			return "withdraw";
		}
	}
}
