package com.bank.payments.dto;

public class AccountDTO {

	private int accountId;
	private Long accountNumber;
	private Long currentBalance;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Long currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return "AccountDTO [accountId=" + accountId + ", accountNumber=" + accountNumber + ", currentBalance="
				+ currentBalance + "]";
	}

}
