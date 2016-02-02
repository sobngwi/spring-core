package com.sobngwi.entities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Game game=context.getBean("game", Game.class);
		Lyon lyon = context.getBean("lyon", Lyon.class);
		Paris paris = context.getBean("paris", Paris.class);
		Marseille marseille = context.getBean("marseille", Marseille.class);

		game.setHomeTeam(paris);
		game.setAwayTeam(marseille);
		System.out.println(game.playGame());

		game.setHomeTeam(paris);
		game.setAwayTeam(lyon);
		System.out.println(game.playGame());

	}

}
