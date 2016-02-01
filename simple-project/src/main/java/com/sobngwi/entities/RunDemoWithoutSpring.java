package com.sobngwi.entities;

public class RunDemoWithoutSpring {

	public static void main(String[] args) {

		  Team marseille = new Marseille();
		  Team paris 	 = new Paris();
		  
		  Game game = new FootballGame(marseille, paris) ;
		  System.out.println(game.playGame());
	}

}
