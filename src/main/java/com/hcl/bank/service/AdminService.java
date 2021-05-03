package com.hcl.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.bank.exception.AdminDoesNotExistsException;
import com.hcl.bank.model.Admin;
import com.hcl.bank.repositry.AdminRepositry;
import com.hcl.bank.utility.AdminUtility;


@Service
public class AdminService {
	@Autowired

	AdminRepositry adminRepositry;

	public boolean login(String adminname, String password) throws AdminDoesNotExistsException {
		Admin admin = adminRepositry.findByAdminnameAndPassword(adminname, password);
		if (!ObjectUtils.isEmpty(admin))
			return true;
		else
			throw new AdminDoesNotExistsException(AdminUtility.ADMIN_DOESNOT_EXISTS_ERROR);
	}

}
