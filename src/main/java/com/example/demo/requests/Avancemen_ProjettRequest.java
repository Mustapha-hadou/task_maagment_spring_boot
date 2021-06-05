package com.example.demo.requests;

import java.util.Date;

public class Avancemen_ProjettRequest {
	
	private String titre;
	private int score;
	private Date date_ajout;
	
	public Avancemen_ProjettRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Avancemen_ProjettRequest(String titre, int score, Date date_ajout) {
		super();
		titre = titre;
		this.score = score;
		this.date_ajout = date_ajout;
	}
	
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getDate_ajout() {
		return date_ajout;
	}
	public void setDate_ajout(Date date_ajout) {
		this.date_ajout = date_ajout;
	}
	
	
}
