package com.account.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.account.system.model.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	@Query("SELECT a from Account a where a.account_number = ?1")
	Account findByaccount_number(int code);

	
}
