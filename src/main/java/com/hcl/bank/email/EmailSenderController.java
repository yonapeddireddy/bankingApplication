package com.hcl.bank.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hcl.bank.model.User;
import com.hcl.bank.repositry.UserRepositry;

@Controller
public class EmailSenderController {

	@Autowired
	public JavaMailSender javaMailSender;
	@Autowired
	UserRepositry userRepositry;
	static Integer UserId;

	public EmailSenderController() {

	}

	public EmailSenderController(Integer userid) {
		UserId = userid;
		System.out.println(UserId);
	}

	@GetMapping("/email")
	public String sendEmail() {

		SimpleMailMessage message = new SimpleMailMessage();
		System.out.println(UserId);
		User user = userRepositry.findByUserId(UserId);
		String email = user.getEmail();
		message.setTo(email);
		message.setSubject("ABC Bank");
		message.setText("Your Account Generated Successfully");
		javaMailSender.send(message);

		return "accountgeneratesuccess";
	}
}
