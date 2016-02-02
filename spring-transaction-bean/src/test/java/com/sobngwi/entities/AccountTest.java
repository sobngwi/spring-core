package com.sobngwi.entities;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sobngwi.dao.JdbcAccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InfrastructureConfig.class)
@Transactional
@ActiveProfiles("test")
public class AccountTest {

	@Autowired
	protected JdbcAccountRepository jdbcAccountRepository ;

	@Test
	public void should_initialiez_bean_without_error(){
		assertNotNull(jdbcAccountRepository);
	}
	
}
