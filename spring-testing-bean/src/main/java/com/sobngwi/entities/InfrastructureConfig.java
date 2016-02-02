package com.sobngwi.entities;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.sobngwi.aspect.LoggingAspect;

@Configuration
public class InfrastructureConfig {

	@Bean
	public DataSource datasource(){
		return new DriverManagerDataSource();
	}
	
	@Bean
	public LoggingAspect loggingAspect() {
		return new LoggingAspect() ;
	}
	
}
