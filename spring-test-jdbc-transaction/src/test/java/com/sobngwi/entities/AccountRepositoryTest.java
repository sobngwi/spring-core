package com.sobngwi.entities;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

public class AccountRepositoryTest extends AccountTest{



	@Test
	public void testGetAccounts() {
		List<Account> accounts = jdbcAccountRepository.getAccounts() ;
		
		assertThat(accounts.size(), is(3));
	}

	@Test
	public void testGetAccount() {
		Account account = jdbcAccountRepository.getAccount(1L);
		
		assertThat( account.getId(), is(1L));
		assertThat(new BigDecimal("100.0"),
				is(closeTo(account.getBalance(), new BigDecimal("0.01")))) ;
	}

	@Test
	public void testGetNumberOfAccounts() {
		assertThat( jdbcAccountRepository.getNumberOfAccounts(), is(3));
	}

	@Test
	public void testCreateAccount() {
		Long id = jdbcAccountRepository.createAccount(new BigDecimal("250.05"));
		Account account = jdbcAccountRepository.getAccount(id);
		
		assertThat(id , is(notNullValue()));
		assertThat(account.getId(), is(id));
		assertThat(account.getBalance(),
				is(closeTo(account.getBalance(), new BigDecimal("0.01")))) ;
	}

	@Test
	public void testDeleteAccount() {
		for (Account account : jdbcAccountRepository.getAccounts()) {
			jdbcAccountRepository.deleteAccount(account.getId());
		}
		
		assertThat(jdbcAccountRepository.getNumberOfAccounts(), is(0));
	}

	@Test
	public void testUpdateAccount() {
		Account account = jdbcAccountRepository.getAccount(1L);
		BigDecimal newAccountBalance = new BigDecimal("50.0");
		account.setBalance(newAccountBalance);
		
		jdbcAccountRepository.updateAccount(account);
		
		assertThat(jdbcAccountRepository.getAccount(1l).getBalance(),
				is(closeTo(newAccountBalance, new BigDecimal("0.01"))));
	
	}

}
