package com.bank.payments.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.payments.dto.AccountStatementResponse;
import com.bank.payments.dto.TransactionHistoryResponse;
import com.bank.payments.dto.TransferBalanceRequest;
import com.bank.payments.entity.Account;
import com.bank.payments.entity.TransactionHistory;
import com.bank.payments.repository.AccountRepository;
import com.bank.payments.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {
	Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
	@Autowired
	public AccountRepository accountRepository;

	@Autowired
	public TransactionRepository transactionRepository;

	@Override
	public TransactionHistoryResponse sendMoney(TransferBalanceRequest transferBalanceRequest) {
		LOGGER.info("Enter into sendMoney method in AccountServiceImpl with request::{}", transferBalanceRequest);
		String fromAccountNumber = transferBalanceRequest.getFromAccountNumber();
		String toAccountNumber = transferBalanceRequest.getToAccountNumber();
		BigDecimal amount = transferBalanceRequest.getAmount();
		Account fromAccount = accountRepository.findByAccountNumberEquals(fromAccountNumber);
		Account toAccount = accountRepository.findByAccountNumberEquals(toAccountNumber);
		if (null != fromAccount && null != toAccount && fromAccount.getCurrentBalance().compareTo(BigDecimal.ONE) == 1
				&& fromAccount.getCurrentBalance().compareTo(amount) == 1) {

			fromAccount.setCurrentBalance(fromAccount.getCurrentBalance().subtract(amount));
			accountRepository.save(fromAccount);
			LOGGER.info("After update fromAccount number::{}", fromAccount);

			toAccount.setCurrentBalance(toAccount.getCurrentBalance().add(amount));
			accountRepository.save(toAccount);
			LOGGER.info("After update toAccount values::{}", toAccount);

			TransactionHistory transaction = transactionRepository
					.save(new TransactionHistory(0L, fromAccountNumber, toAccountNumber, amount, LocalDateTime.now()));

			TransactionHistoryResponse transactionHistoryDTO = new TransactionHistoryResponse();
			transactionHistoryDTO.setTransactionId(transaction.getTransactionId());
			transactionHistoryDTO.setFromAccountNumber(transaction.getFromAccountNumber());
			transactionHistoryDTO.setToAccountNumber(transaction.getToAccountNumber());
			transactionHistoryDTO.setTransactionAmount(transaction.getTransactionAmount());
			transactionHistoryDTO.setTransactionDateTime(transaction.getTransactionDateTime());
			LOGGER.info("Exit from sendMoney method with transaction ::{}", transactionHistoryDTO);

			return transactionHistoryDTO;
		}
		return null;
	}

	@Override
	public AccountStatementResponse getStatement(String accountNumber) {

		Account account = accountRepository.findByAccountNumberEquals(accountNumber);
		if (null != account) {
			List<TransactionHistory> listofTransactions = transactionRepository.findByFromAccountNumber(accountNumber);

			List<TransactionHistoryResponse> ListOfTransactionHistoryDto = new ArrayList<>();
			listofTransactions.stream().forEach(transaction -> {
				TransactionHistoryResponse transactionHistoryDTO = new TransactionHistoryResponse();
				transactionHistoryDTO.setTransactionId(transaction.getTransactionId());
				transactionHistoryDTO.setFromAccountNumber(transaction.getFromAccountNumber());
				transactionHistoryDTO.setToAccountNumber(transaction.getToAccountNumber());
				transactionHistoryDTO.setTransactionAmount(transaction.getTransactionAmount());
				transactionHistoryDTO.setTransactionDateTime(transaction.getTransactionDateTime());
				ListOfTransactionHistoryDto.add(transactionHistoryDTO);
			});
			return new AccountStatementResponse(accountNumber, account.getCurrentBalance(), ListOfTransactionHistoryDto) {
			};
		} else {
			return null;
		}

	}

}
