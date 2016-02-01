package com.sobngwi.entities;

import javax.sql.DataSource;

public class FootballGame implements Game{
	
	private Team  homeTeam ;
	private Team  awayTeam;
	private DataSource datasource ;
	
	
	public FootballGame() {}
	public FootballGame(Team homeTeam, Team localTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = localTeam;
	};
	
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
	
	@Override
	public Team getHomeTeam() {
		return homeTeam;
	}
	
	@Override
	public Team getAwayTeam() {
		return awayTeam;
	}

	@Override
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	@Override
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public DataSource getDatasource() {
		return datasource;
	}
	
	@Override
	public String playGame() {
		return Math.random() < 0.5 ? getHomeTeam().getName() : getAwayTeam().getName();
	}
	@Override
	public String toString() {
		return String.format("FootballGame between %s @ %s ",  awayTeam.getName(), homeTeam.getName());
	}
	
	

}
