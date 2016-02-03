package com.sobngwi.entities;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

public class AccountRepositoryTestJpa extends AccountTestJpa{



	@Test
	public void testGetAccounts() {
		List<Account> accounts = accountRepositoryJpa.getAccounts() ;
		
		assertThat(accounts.size(), is(3));
	}

	@Test
	public void testGetAccount() {
		Account account = accountRepositoryJpa.getAccount(1L);
		
		assertThat( account.getId(), is(1L));
		assertThat(new BigDecimal("100.0"),
				is(closeTo(account.getBalance(), new BigDecimal("0.01")))) ;
	}

	@Test
	public void testGetNumberOfAccounts() {
		assertThat( accountRepositoryJpa.getNumberOfAccounts(), is(3));
	}

	@Test
	public void testCreateAccount() {
		Long id = accountRepositoryJpa.createAccount(new BigDecimal("250.05"));
		Account account = accountRepositoryJpa.getAccount(id);
		
		assertThat(id , is(notNullValue()));
		assertThat(account.getId(), is(id));
		assertThat(account.getBalance(),
				is(closeTo(account.getBalance(), new BigDecimal("0.01")))) ;
	}

	@Test
	public void testDeleteAccount() {
		for (Account account : accountRepositoryJpa.getAccounts()) {
			accountRepositoryJpa.deleteAccount(account.getId());
		}
		
		assertThat(accountRepositoryJpa.getNumberOfAccounts(), is(0));
	}

	@Test
	public void testUpdateAccount() {
		Account account = accountRepositoryJpa.getAccount(1L);
		BigDecimal newAccountBalance = new BigDecimal("50.0");
		account.setBalance(newAccountBalance);
		
		accountRepositoryJpa.updateAccount(account);
		
		assertThat(accountRepositoryJpa.getAccount(1l).getBalance(),
				is(closeTo(newAccountBalance, new BigDecimal("0.01"))));
	
	}

}
