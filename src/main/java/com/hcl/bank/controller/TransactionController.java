package com.hcl.bank.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hcl.bank.dto.AdminDto;
import com.hcl.bank.dto.FullStatementDto;
import com.hcl.bank.dto.TransactionDTO;
import com.hcl.bank.exception.AccountNumberNotFoundException;
import com.hcl.bank.exception.AdminDoesNotExistsException;
import com.hcl.bank.exception.BalanceInsufficientException;
import com.hcl.bank.exception.NoTransactionsException;
import com.hcl.bank.exception.SameAccountNumberException;
import com.hcl.bank.exception.ZeroBalanceException;
import com.hcl.bank.model.Transaction;
import com.hcl.bank.service.TransactionService;

@Controller
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	static String UserName;

	public TransactionController() {
		// TODO Auto-generated constructor stub
	}

	public TransactionController(@Valid String username) {
		UserName = username;
	}

	@GetMapping("/transaction")
	public String transaction(Map<String, Object> model) {
		model.put("transaction", new TransactionDTO());
		return "transaction";
	}

	@PostMapping("/savetransaction")
	public String saveTransaction(@ModelAttribute("transaction") TransactionDTO transactionDto)
			throws BalanceInsufficientException, AccountNumberNotFoundException, SameAccountNumberException, ZeroBalanceException {
		TransactionService transaction = new TransactionService(UserName);
		boolean response = transactionService.saveTransaction(transactionDto);
		if (response == true) {
			return "transactionsuccess";
		} else {
			return "transaction";
		}
	}

	@GetMapping("/transactionlist")
	public String transactionlist(Map<String, Object> model) {
		return "transactionlist";
	}

	@GetMapping("/transactionslist")
	public String transactionList(TransactionDTO transactionDto, Model m)
			throws NoTransactionsException, AccountNumberNotFoundException {

		List<Transaction> transactions = transactionService.transactionList(transactionDto);
		m.addAttribute("transactionList", transactions);
		if (transactions.size() != 0) {
			return "ministatement";
		} else {
			return "transactionlist";
		}
	}

	@GetMapping("/fulltransactionlist")
	public String fulltransactionlist(Map<String, Object> model) {
		return "fulltransactionlist";
	}

	@GetMapping("/fulltransactionslist")
	public String detailedtransactionList(FullStatementDto transactionDTO, Model m)
			throws NoTransactionsException, AccountNumberNotFoundException {

		List<Transaction> transactions = transactionService.detailedtransactionList(transactionDTO);
		m.addAttribute("transactionList", transactions);
		if (transactions.size() != 0) {
			return "fullstatement";
		} else {
			return "fulltransactionlist";
		}
	}
}
