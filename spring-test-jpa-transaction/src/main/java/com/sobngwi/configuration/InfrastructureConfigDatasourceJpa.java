package com.sobngwi.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:prod.properties")
@ComponentScan({"com.sobngwi.repositoryjpa.impl"})
public class InfrastructureConfigDatasourceJpa {

	@Autowired
	private Environment env;
	
	@Bean ( name = "dataSource")
	@Profile("jpa-prod")
	public DataSource dataSourceProdJpa(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.user"));
		dataSource.setPassword(env.getProperty("db.pass"));
		
		return dataSource;
	}
	@Bean ( name = "dataSource")
	@Profile("jpa-test")
	public DataSource dataSourceTestJpa(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.user"));
		dataSource.setPassword(env.getProperty("db.pass"));
		
		return dataSource;
	}
	
	

}
