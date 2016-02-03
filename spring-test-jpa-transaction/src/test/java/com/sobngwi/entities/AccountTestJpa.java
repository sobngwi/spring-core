package com.sobngwi.entities;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sobngwi.configuration.InfrastructureConfigJdbc;
import com.sobngwi.configuration.InfrastructureConfigJpa;
import com.sobngwi.repositoryjpa.impl.AccountRepositoryJpa;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InfrastructureConfigJpa.class)
@Transactional
public class AccountTestJpa {

	@Autowired
	protected AccountRepositoryJpa jpaAccountRepositoryJpa ;

	@Test
	public void should_initialiez_bean_without_error(){
		assertNotNull(jpaAccountRepositoryJpa);
	}
	
}
