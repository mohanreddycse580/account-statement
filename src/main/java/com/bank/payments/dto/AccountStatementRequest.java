package com.bank.payments.dto;

public class AccountStatementRequest {
	private String accountNumber;

	@Override
	public String toString() {
		return "AccountStatementRequest [accountNumber=" + accountNumber + "]";
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}
