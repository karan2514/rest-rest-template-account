package com.account.system.service;

import java.util.List;

import com.account.system.model.Account;

public interface AccountService {

	public Account addAccount(Account bank);
	public Account updateAccount(Account bank);
	public void deleteAccount(Integer id);
	public List<Account> getAllAccounts();
	public Account findAccountById(Integer id);
	public Account findByaccount_number(int code);
}
