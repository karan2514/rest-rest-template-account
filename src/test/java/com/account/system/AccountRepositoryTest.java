package com.account.system;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.GreaterThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.account.system.model.Account;
import com.account.system.repository.AccountRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AccountRepositoryTest {

	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void testAccountCreate() {
		Account account = new Account();
		account.setAccount_number(12786547);
		account.setBalance(2500);
		account.setDescription("savings");
		Account savedAccount = accountRepository.save(account);
		
		assertThat(savedAccount).isNotNull();
	}
	
	@Test
	public void testfindAccountByAccNumber() {
		
		Account account = accountRepository.findByaccount_number(12786547);
		assertThat(account).isNotNull();
	}
	
}

