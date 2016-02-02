package com.sobngwi.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sobngwi.dao.AccountRepository;
import com.sobngwi.entities.Account;

@Service
@Transactional
@Profile("test")
public class AccountService {
	
	@Autowired
	private AccountRepository repository;
	
	@Transactional(readOnly=true)
	public BigDecimal getBalance(Long accountId) {
		return repository.getAccount(accountId).getBalance() ;
	}
	
	public BigDecimal deposit(Long accountId, BigDecimal amount){
		Account account = repository.getAccount(accountId);
		BigDecimal newBalance = account.getBalance().add(amount);
		repository.updateAccount(account);
		return newBalance;
	}
	
	public BigDecimal withdraw ( Long accountId, BigDecimal amount){
		return deposit(accountId, amount.negate());
	}
	
}
