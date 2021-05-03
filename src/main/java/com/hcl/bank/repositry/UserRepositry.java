package com.hcl.bank.repositry;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bank.model.User;

@Repository
public interface UserRepositry extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	User findByUserId(Integer userid);

	User findByUsernameAndPassword(@Valid String username, String password);

}
