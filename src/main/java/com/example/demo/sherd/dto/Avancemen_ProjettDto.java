package com.example.demo.sherd.dto;

import java.util.Date;

import com.example.demo.entities.ProjetEntity;

public class Avancemen_ProjettDto {
	private Long id;
	private String Titre ;
	private int score;
	private Date date_ajout;
	private ProjetDto projet;
	
	
	
	
	public Avancemen_ProjettDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Avancemen_ProjettDto(Long id, String titre, int score, Date date_ajout, ProjetDto projet) {
		super();
		this.id = id;
		Titre = titre;
		this.score = score;
		this.date_ajout = date_ajout;
		this.projet = projet;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public ProjetDto getProjet() {
		return projet;
	}
	public void setProjet(ProjetDto projet) {
		this.projet = projet;
	}
	
}
