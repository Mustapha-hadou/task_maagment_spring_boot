package com.example.demo.repances;

import java.util.Date;

public class ProjetResponse {
	
	private String prjet_id;
	private String titre;
	private String description;
	private Date date_debut;
	private Date date_fin;
	private String status;
	private String document;
	public String getPrjet_id() {
		return prjet_id;
	}
	public void setPrjet_id(String prjet_id) {
		this.prjet_id = prjet_id;
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
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	
	
}
