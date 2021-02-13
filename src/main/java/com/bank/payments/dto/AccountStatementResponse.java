package com.bank.payments.dto;

import java.math.BigDecimal;
import java.util.List;

public class AccountStatementResponse {
	private String accountNumber;
	private BigDecimal currentBalance;
    private List<TransactionHistoryResponse> transactionHistory;
	
	public AccountStatementResponse(String accountNumber, BigDecimal currentBalance,
			List<TransactionHistoryResponse> transactionHistory) {
		super();
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
		this.transactionHistory = transactionHistory;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountStatementResponse() {
		super();
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
	public List<TransactionHistoryResponse> getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(List<TransactionHistoryResponse> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	@Override
	public String toString() {
		return "AccountStatement [currentBalance=" + currentBalance + ", transactionHistory=" + transactionHistory
				+ "]";
	}
    
}
