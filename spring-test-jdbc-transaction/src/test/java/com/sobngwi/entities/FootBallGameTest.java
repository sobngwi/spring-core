package com.sobngwi.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FootBallGameTest extends GameTest {
	
	

	@Before
	public void setUp() throws Exception {
	  
		
	}

	@Test
	public void testPlayGame() {
		String home = game.getHomeTeam().getName();
		String away = game.getAwayTeam().getName();
		
		String result = game.playGame() ;

		assertTrue(result.equals("Post-Poned") ||result.contains(home) || result.contains(away) );
	}
	
	@Test
	public void homeAndAwayAreNotNull() {
		String home = game.getHomeTeam().getName();
		String away = game.getAwayTeam().getName();
		
		 game.playGame() ;

		assertNotNull(home);
		assertNotNull(away);
		
	}
	
	@Test
	public void theHomeTeamSetOperationIsCorrectlyUpdated() {
		 Team lyon = context.getBean("lyon", Lyon.class);
		 game.setHomeTeam(lyon);
		 
		 game.playGame() ;

		 assertEquals(lyon.getName(), game.getHomeTeam().getName());
		
	}

}
