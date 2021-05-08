package com.example.demo.requests;

import java.util.Date;

public class Avancemen_ProjettRequest {
	private String Titre ;
	private int score;
	private Date date_ajout;
	
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
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
