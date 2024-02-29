package com.account.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.account.system.model.Account;
import com.account.system.service.AccountService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/account")
public class AccountRestController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/create")
	public Account createAccount(@RequestBody Account account) {
		return accountService.addAccount(account);
	}
	
	@GetMapping("/accounts")
	public List<Account> getMethodName() {
		return accountService.getAllAccounts();
	}
	
	@PutMapping("/accounts/{id}")
	public Account updateAccount(@PathVariable("id") Integer id,@RequestBody Account account) {
		//Bank existingBank = bankService.findBankById(id);
		account.setId(id);
		Account updatedAccount = accountService.updateAccount(account);
		return updatedAccount;
	}
	
	@DeleteMapping("/accounts/{id}")
	public void deleteAccount(@PathVariable("id") Integer id) {
		accountService.deleteAccount(id);
	}
	
	@GetMapping("/accounts/{account_number}")
	public Account getAccountByAccountNumber(@PathVariable("account_number") Integer number) {
		return accountService.findByaccount_number(number);
	}
	
	
}
