package com.sobngwi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sobngwi.entities.Account;

public class AccountRowMapper implements RowMapper<Account> {
	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Account(rs.getLong("id"), rs.getBigDecimal("balance") ) ;
	}

}
