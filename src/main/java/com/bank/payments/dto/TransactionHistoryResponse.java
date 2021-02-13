package com.bank.payments.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionHistoryResponse {

	private Long transactionId;
	
	private String fromAccountNumber;
	
	private String toAccountNumber;

	private BigDecimal transactionAmount;

	private LocalDateTime transactionDateTime;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}


	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "TransactionHistoryDTO [transactionId=" + transactionId + ", fromAccountNumber=" + fromAccountNumber
				+ ", toAccountNumber=" + toAccountNumber + ", transactionAmount=" + transactionAmount
				+ ", transactionDateTime=" + transactionDateTime + "]";
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime localDateTime) {
		this.transactionDateTime = localDateTime;
	}

	

}
