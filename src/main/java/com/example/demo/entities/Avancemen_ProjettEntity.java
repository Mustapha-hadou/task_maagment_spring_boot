package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "avancemen_ProjettEntity")
public class Avancemen_ProjettEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String Titre ;
	private int score;
	private Date date_ajout;
	
	@ManyToOne()
	@JoinColumn()
	private ProjetEntity projet;

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

	public ProjetEntity getProjet() {
		return projet;
	}

	public void setProjet(ProjetEntity projet) {
		this.projet = projet;
	}

	public Avancemen_ProjettEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Avancemen_ProjettEntity(Long id, String titre, int score, Date date_ajout, ProjetEntity projet) {
		super();
		this.id = id;
		Titre = titre;
		this.score = score;
		this.date_ajout = date_ajout;
		this.projet = projet;
	}

	
}
