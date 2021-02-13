package com.bank.payments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.payments.entity.TransactionHistory;

public interface TransactionRepository extends JpaRepository<TransactionHistory, Long> {

	List<TransactionHistory> findByFromAccountNumber(String accountNumber);
	
}
