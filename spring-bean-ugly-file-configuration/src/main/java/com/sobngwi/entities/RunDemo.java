package com.sobngwi.entities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Game game=context.getBean("football", Game.class);
		 
		System.out.println(game.playGame());
		System.out.println( "There are " + context.getBeanDefinitionCount() + " beans In the Container Rigth now.");
		for (String beanName : context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		
	}

}
