 package com.hcl.bank.controllertest;

import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.bank.controller.UserController;
import com.hcl.bank.dto.AdminDto;
import com.hcl.bank.exception.AdminDoesNotExistsException;
import com.hcl.bank.service.AdminService;
import com.hcl.bank.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	@InjectMocks
	UserController userController;
	@Mock
	UserService userService;
	@Mock
	AdminService adminService;
	AdminDto adminDto;
	String adminName;
	String password;

	@Before
	public void setup() {
		// adminName = "yona";
		// password = "abc123";
		adminDto = new AdminDto();
		adminDto.setAdminname("yona");
		adminDto.setPassword("abc123");
		System.out.println(adminDto.getPassword());
	}

	@Test
	public void loginAdminTest() throws AdminDoesNotExistsException {
		String message = "redirect:/userdirection";
		boolean b = true;

		Mockito.when(adminService.login(Mockito.anyString(), Mockito.anyString())).thenReturn(b);
		String s = userController.loginAdmin(adminDto.getAdminname(), adminDto.getPassword());

		Assert.assertEquals(message, s);
	}
}
