package com.hcl.bank.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.dto.AccountDTO;
import com.hcl.bank.dto.AdminDto;
import com.hcl.bank.dto.UserDTO;
import com.hcl.bank.exception.AdminDoesNotExistsException;
import com.hcl.bank.exception.UserDoesNotExistsErrorException;
import com.hcl.bank.exception.UserExistsException;
import com.hcl.bank.service.AccountService;
import com.hcl.bank.service.AdminService;
import com.hcl.bank.service.TransactionService;
import com.hcl.bank.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	AdminService adminService;

	@GetMapping("/login")
	public String reg(Map<String, Object> model) {
		model.put("admin", new AdminDto());
		return "adminLogin";
	}

	@PostMapping("/adminlogin")
	public String loginAdmin(@ModelAttribute("admin") @Valid @RequestParam(required = false) String adminname,
			@RequestParam(required = false) String password) throws AdminDoesNotExistsException {

		boolean response = adminService.login(adminname, password);
		if (response == true) {
			return "redirect:/userdirection";

		} else {
			return "adminLogin";

		}
	}

	@GetMapping("/userlogin")
	public String userlogin(Map<String, Object> model) {
		model.put("user", new UserDTO());
		return "userlogin";
	}

	@PostMapping("/Userlogin")
	public String loginUser(@ModelAttribute("user") @Valid @RequestParam(required = false) String username,
			@RequestParam(required = false) String password)
			throws AdminDoesNotExistsException, UserDoesNotExistsErrorException {

		boolean response = userService.login(username, password);
		if (response == true) {
			System.out.println(username);
			TransactionController userName=new TransactionController(username);
			return "redirect:/transaction";

		} else {
			return "transaction";

		}
	}

	@GetMapping("/userdirection")
	public String usersave(Map<String, Object> model) {
		model.put("usersave", new UserDTO());
		return "adminhome";
	}

	@PostMapping("/saveuserdetails")
	public String saveUser(@ModelAttribute("usersave") UserDTO userDto) throws UserExistsException {
		boolean response = userService.saveUser(userDto);
		if (response == true) {

			return "redirect:/accountdirection";

		} else {
			return "adminhome";

		}
	}

	@GetMapping("/updatepassword")
	public String updatepassword(Map<String, Object> model) {
		model.put("update", new UserDTO());
		return "updatepassword";
	}

	@PostMapping("/update")
	public String updatePassword(@Valid @ModelAttribute("update") UserDTO userDto)
			throws UserDoesNotExistsErrorException {

		boolean response = userService.updatePassword(userDto);
		if (response == true) {

			return "updatepasswordsuccess";

		} else {
			return "updatepassword";

		}
	}
}
