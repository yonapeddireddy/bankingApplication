package com.hcl.bank.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bank.model.Admin;


@Repository
public interface AdminRepositry extends JpaRepository<Admin, Integer>{

	Admin findByAdminnameAndPassword(String adminname, String password);

}
