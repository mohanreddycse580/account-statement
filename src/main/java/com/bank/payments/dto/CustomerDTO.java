package com.bank.payments.dto;

public class CustomerDTO {

	private Long customerId;
	private String emailId;
	private String firstName;
	private String lastName;
	private AccountDTO accountDto;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AccountDTO getAccountDto() {
		return accountDto;
	}

	public void setAccountDto(AccountDTO accountDto) {
		this.accountDto = accountDto;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", emailId=" + emailId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", accountDto=" + accountDto + "]";
	}

}
