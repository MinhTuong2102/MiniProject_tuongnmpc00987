package com.mini_project.services;

import java.util.List;

import com.mini_project.entity.Account;


public interface AccountService {
	
	Account findById(String username);

	List<Account> getAdministrators();

	List<Account> findAll();

	Account create(Account account);

	Account update(Account account);

	void delete(String username);
}
