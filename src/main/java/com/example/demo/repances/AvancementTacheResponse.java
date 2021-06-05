package com.example.demo.repances;

import java.util.Date;

import com.example.demo.sherd.dto.TacheDto;

public class AvancementTacheResponse {

	
	
	private String titre;
	private Date date_ajout;
	private String score;

	public AvancementTacheResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AvancementTacheResponse(String titre, Date date_ajout, String score) {
		super();
		this.titre = titre;
		this.date_ajout = date_ajout;
		this.score = score;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDate_ajout() {
		return date_ajout;
	}
	public void setDate_ajout(Date date_ajout) {
		this.date_ajout = date_ajout;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
}
