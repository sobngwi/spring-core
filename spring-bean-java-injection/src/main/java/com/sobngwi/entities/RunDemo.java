package com.sobngwi.entities;

import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Game game=context.getBean("game", Game.class);
		System.err.println(game);
		System.out.println(game.playGame());
		Lyon lyon = context.getBean("lyon", Lyon.class);
		Game game1=context.getBean("game", Game.class);
		game1.setHomeTeam(lyon);
		System.err.println(game1);
		System.err.println(game1.playGame());
		System.out.println( "There are " + context.getBeanDefinitionCount() + " beans In the Container Rigth now.");
		for (String beanName : context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		System.out.println("By default all bean are scope :  siingleton ");
		System.err.println(game);
		System.err.println(game1);
		NumberFormat nf = context.getBean("numberFormat", NumberFormat.class);
		double amount = 123456789.987654321;
		System.out.println(nf.format(amount));

	}

}
