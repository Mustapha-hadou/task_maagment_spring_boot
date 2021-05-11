package com.example.demo.sherd.dto;

import java.util.Date;

public class AvancementTacheDto {

	private String titre;
	private Date date_ajout;
	private String score;
	private TacheDto tache;

	public AvancementTacheDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AvancementTacheDto(String titre, Date date_ajout, String score, TacheDto tache) {
		super();
		this.titre = titre;
		this.date_ajout = date_ajout;
		this.score = score;
		this.tache = tache;
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
	public TacheDto getTache() {
		return tache;
	}
	public void setTache(TacheDto tache) {
		this.tache = tache;
	}
	
	
	
	
	
}
