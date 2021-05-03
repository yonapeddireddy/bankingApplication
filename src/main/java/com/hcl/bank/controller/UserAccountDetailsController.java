package com.hcl.bank.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.bank.dto.UserAccountDetailsDTO;
import com.hcl.bank.dto.UserDTO;
import com.hcl.bank.exception.AccountNumberNotFoundException;
import com.hcl.bank.exception.UserDoesNotExistsErrorException;
import com.hcl.bank.service.UserService;

@Controller
public class UserAccountDetailsController {
	@Autowired
	UserService userservice;

	@GetMapping("/useraccountdetails")
	public String transactionlist(Map<String, Object> model) {
		return "userdetails";
	}

	@GetMapping("/useraccountDetails")
	public String search(@RequestParam(required = false) String username,
			@RequestParam(required = false) Long accountno, Model m)
			throws UserDoesNotExistsErrorException, AccountNumberNotFoundException {

		UserAccountDetailsDTO response = userservice.search(username, accountno);
		System.out.println(response);
		m.addAttribute("details",response);
		if (!ObjectUtils.isEmpty(response)) {
			return "details";
		} else {
			return "userdetails";
		}
	}

}
