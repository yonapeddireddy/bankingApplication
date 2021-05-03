package com.hcl.bank.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bank.model.Account;


@Repository
public interface AccountRepositry extends JpaRepository<Account, Integer> {

	Account findByAccountNumber(long accountnumber);

	Account findByUserid(Integer userid);

}
