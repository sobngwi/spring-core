package com.sobngwi.repositoryjpa.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sobngwi.entities.Account;
import com.sobngwi.repository.AccountRepository;

@Repository
public class AccountRepositoryJpa implements AccountRepository {

	private static long nextId =0 ;
	
	@PersistenceContext
	private EntityManager entitymanager;
	
	
	@Override
	public List<Account> getAccounts() {
		return entitymanager.createQuery("from Account", Account.class)
							.getResultList();
	}

	@Override
	public Account getAccount(Long id) {
		return entitymanager.find(Account.class, id);
	}

	@Override
	public int getNumberOfAccounts() {
		String sqltext = "select count(a.id) from Account a"; // as a.id is unique : the key
		Long result = (Long) entitymanager.createQuery(sqltext)
								.getSingleResult();
		return result.intValue();
	}

	@Override
	public long createAccount(BigDecimal initalAmount) {
		long id = nextId++ ;
		entitymanager.persist(new Account(id, initalAmount));
		return id ;
		
	}

	@Override
	public int deleteAccount(Long accountId) {
		entitymanager.remove(getAccount(accountId));
		return 1;
	}

	@Override
	public void updateAccount( Account account) {
		entitymanager.merge(account);

	}	

}
