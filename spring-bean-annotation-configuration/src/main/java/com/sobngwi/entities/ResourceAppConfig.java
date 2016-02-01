package com.sobngwi.entities;

import javax.annotation.Resource;
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
public class ResourceAppConfig {
	
	@Resource// autowire by name
	private DataSource datasource ;
	@Resource 
	private Team marseille;
	@Resource
	private Team paris;
	
	@Bean
	public Game game(){
		FootballGame football = new FootballGame(paris, marseille) ;
		football.setDatasource(datasource);
		return  football;
	}

}
