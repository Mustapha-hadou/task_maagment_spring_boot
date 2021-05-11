package com.example.demo.repances;

import java.util.Date;
import java.util.List;

import com.example.demo.sherd.dto.Avancemen_ProjettDto;
import com.example.demo.sherd.dto.TacheDto;
import com.example.demo.sherd.dto.UserDto;

public class ProjetResponse {
	
	private String prjet_id;
	private String titre;
	private String description;
	private Date date_debut;
	private Date date_fin;
	private String status;
	private String document;
	private List<Avancemen_ProjettResponse> avancementsProjet;
	private List<UserRepance> employes;

	private List<TacheResponse> taches;
	
	
	public List<Avancemen_ProjettResponse> getAvancementsProjet() {
		return avancementsProjet;
	}
	public void setAvancementsProjet(List<Avancemen_ProjettResponse> avancementsProjet) {
		this.avancementsProjet = avancementsProjet;
	}
	public List<UserRepance> getEmployes() {
		return employes;
	}
	public void setEmployes(List<UserRepance> employes) {
		this.employes = employes;
	}
	public List<TacheResponse> getTaches() {
		return taches;
	}
	public void setTaches(List<TacheResponse> taches) {
		this.taches = taches;
	}
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
