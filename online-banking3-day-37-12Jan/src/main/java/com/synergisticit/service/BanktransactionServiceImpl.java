package com.synergisticit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.BankTransaction;
import com.synergisticit.repository.BankTransactionRepository;



@Service
public class BanktransactionServiceImpl implements BankTransactionService{
	@Autowired BankTransactionRepository bankTransactionRepository;

	@Override
	public BankTransaction saveTransaction(BankTransaction bankTransaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankTransaction getTransactionId(Long bankTransactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankTransaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankTransaction updateTransactionById(Long bankTransactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTransactionById(Long bankTransactionId) {
		// TODO Auto-generated method stub
		
	}
	

	
	
}
