package com.sobngwi.entities;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sobngwi.dao.AccountRepository;
import com.sobngwi.dao.JdbcAccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
@ActiveProfiles("test")
@ComponentScan("com.sobngwi")
public class GameTest {

	@Autowired
	protected ApplicationContext context;
	@Autowired
	protected Game  game;
	
	@Autowired
	protected JdbcAccountRepository jdbcAccountRepository ;

}
