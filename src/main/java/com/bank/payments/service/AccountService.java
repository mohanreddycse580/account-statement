package com.bank.payments.service;

import org.springframework.stereotype.Service;

import com.bank.payments.dto.AccountStatementResponse;
import com.bank.payments.dto.TransactionHistoryResponse;
import com.bank.payments.dto.TransferBalanceRequest;

@Service
public interface AccountService {

	TransactionHistoryResponse sendMoney(TransferBalanceRequest transferBalanceRequest);
	
	  AccountStatementResponse getStatement(String accountNumber);

}
