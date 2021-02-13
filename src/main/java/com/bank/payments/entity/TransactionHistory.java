package com.bank.payments.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionHistory {

	@Id
	@GeneratedValue
	private Long transactionId;

	private String fromAccountNumber;
	private String toAccountNumber;

	private BigDecimal transactionAmount;

	@Column(columnDefinition = "TIMESTAMP")
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

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public TransactionHistory(Long transactionId, String fromAccountNumber, String toAccountNumber,
			BigDecimal transactionAmount, LocalDateTime transactionDateTime) {
		super();
		this.transactionId = transactionId;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.transactionAmount = transactionAmount;
		this.transactionDateTime = transactionDateTime;
	}

	public TransactionHistory() {
		super();
	}

}
