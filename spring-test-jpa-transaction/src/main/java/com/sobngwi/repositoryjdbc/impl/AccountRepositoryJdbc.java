package com.sobngwi.repositoryjdbc.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sobngwi.entities.Account;
import com.sobngwi.repository.AccountRepository;
import com.sobngwi.repository.AccountRowMapper;

@Repository
@Profile("test")
public class AccountRepositoryJdbc implements AccountRepository {

	private JdbcTemplate jdbcTemplate;
	private static long nextId =4 ;
	
	@Autowired
	AccountRowMapper accountRowMapper;
	
	@Autowired
	public  AccountRepositoryJdbc(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<Account> getAccounts() {
		String sqltext = "select * from account" ;
		return jdbcTemplate.query(sqltext, accountRowMapper);
	}

	@Override
	public Account getAccount(Long id) {
		String sqltext = "select * from account where id=?" ;
		return jdbcTemplate.queryForObject(sqltext, accountRowMapper, id);
	}

	
	@Override
	public int getNumberOfAccounts() {
		String sqltext = "select count(*) from account" ;
		return jdbcTemplate.queryForObject(sqltext, Integer.class);
	}

	@Override
	public long createAccount(BigDecimal initalAmount) {
		String sqltext = "insert into account(id, balance) values(?,?)";
		long id = nextId++ ;
		jdbcTemplate.update(sqltext, id, initalAmount);
		return id ;
		
	}

	@Override
	public int deleteAccount(Long accountId) {
		String sqltext = "delete from  account where id=?" ;
		return jdbcTemplate.update(sqltext, accountId);
	}

	@Override
	public void updateAccount( Account account) {
		String sqltext = "update   account set balance = ? where id =?" ;
		jdbcTemplate.update(sqltext, account.getBalance(), account.getId());

	}	

}
