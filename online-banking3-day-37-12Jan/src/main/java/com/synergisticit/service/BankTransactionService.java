package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.BankTransaction;


public interface BankTransactionService {
	BankTransaction saveTransaction(BankTransaction bankTransaction);
	BankTransaction getTransactionId(Long  bankTransactionId);
	List<BankTransaction> getAllTransactions();
	BankTransaction updateTransactionById(Long bankTransactionId);
	void deleteTransactionById(Long bankTransactionId);

}
