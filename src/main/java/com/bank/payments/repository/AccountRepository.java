package com.bank.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.payments.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByAccountNumberEquals(String accountNumber);
}
