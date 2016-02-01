package com.sobngwi.entities;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(InfrastructureConfig.class) // Could be an array of Class
@ComponentScan("com.sobngwi")
public class AppConfig {
	
	@Autowired // autowire by type first.This means there is exactly one bean of that type ( class) available.
	private DataSource datasource ;
	@Autowired @Qualifier("marseille")
	private Team home;
	@Autowired @Qualifier("paris")
	private Team away;
	
	@Bean
	public Game game(){
		FootballGame football = new FootballGame(home, away) ;
		football.setDatasource(datasource);
		return  football;
	}

}
