package com.bank.payments.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.payments.dto.AccountStatementResponse;
import com.bank.payments.dto.AccountStatementRequest;
import com.bank.payments.dto.TransactionHistoryResponse;
import com.bank.payments.dto.TransferBalanceRequest;
import com.bank.payments.service.AccountService;

@RestController
public class AccountController {
	Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	@Autowired
	public AccountService accountService;

	@RequestMapping(value = "/sendMoney", method = RequestMethod.POST)
	public TransactionHistoryResponse sendMoney(@RequestBody TransferBalanceRequest request) {
		LOGGER.info("Enter into sendMoney Method with Request::{}", request);
		return accountService.sendMoney(request);

	}

	@RequestMapping(value = "/statement", method = RequestMethod.POST)
	public AccountStatementResponse getStatement(@RequestBody AccountStatementRequest accountStatementRequest

	) {
		return accountService.getStatement(accountStatementRequest.getAccountNumber());
	}

}
