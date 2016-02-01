package com.sobngwi.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(InfrastructureConfig.class) // Could be an array of Class
public class AppConfig {
	
	@Bean
	public Game game(){
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

}
