package com.example.demo.requests;

import java.util.Date;

public class TacheRequest {

	private String titre;
	private String description;
	private Date date_debut;
	private Date date_fin;
	private String status;
	
	public TacheRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TacheRequest(String titre, String description, Date date_debut, Date date_fin, String status) {
		super();
		this.titre = titre;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.status = status;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
