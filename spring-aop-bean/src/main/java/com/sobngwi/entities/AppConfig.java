package com.sobngwi.entities;

import java.text.NumberFormat;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(InfrastructureConfig.class) // Could be an array of Class
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Autowired
	private DataSource datasource;
	
	@Bean( /*initMethod="startFootBallGame", destroyMethod= "endFootBallGame"*/)
	@Scope(scopeName="prototype") // Create a new instance at every request.
	public Game game(){
		FootballGame football =  new FootballGame(marseille(), paris()) ;
		football.setDatasource(datasource);
		return new FootballGame(marseille(), paris());
	}
	
	@Bean
	public Team marseille(){
		return new Marseille();
	}
	
	@Bean
	public Team paris(){
		return new Paris();
	}
	
	@Bean
	public Team lyon(){
		return new Lyon();
	}
	
	@Bean 
	public NumberFormat numberFormat(){
		return NumberFormat.getCurrencyInstance() ;
	}

}
