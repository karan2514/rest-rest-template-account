package com.account.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.system.model.Account;
import com.account.system.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account addAccount(Account bank) {
		
		return accountRepository.save(bank);
	}

	@Override
	public Account updateAccount( Account account) {
		Account existingAccount = accountRepository.findById(account.getId()).get();
		//existingBank.setId(bank.getId());
		existingAccount.setAccount_number(account.getAccount_number());
		existingAccount.setBalance(account.getBalance());
		existingAccount.setDescription(account.getDescription());
		
		
		return accountRepository.save(account);
	}

	@Override
	public void deleteAccount(Integer id) {
		
		accountRepository.deleteById(id);
	}

	@Override
	public List<Account> getAllAccounts() {
		
		return accountRepository.findAll();
	}

	@Override
	public Account findAccountById(Integer id) {
		
		return accountRepository.findById(id).get();
	}

	@Override
	public Account findByaccount_number(int code) {
		
		return accountRepository.findByaccount_number(code);
	}

	

	
}
