package com.example.demo.sherd.dto;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Avancemen_ProjettEntity;
import com.example.demo.entities.TacheEntity;

public class ProjetDto {
	
	private long id;
	private String prjet_id;
	private String titre;
	private String description;
	private Date date_debut;
	private Date date_fin;
	private String status;
	private String document;
	private AdminDto admin;
	private ManagerDto manager;
	private List<Avancemen_ProjettDto> avancementsProjet;

	private List<TacheDto> taches;
	
	
	
	
	
	
	public ProjetDto(long id, String prjet_id, String titre, String description, Date date_debut, Date date_fin, String status,
			AdminDto admin, ManagerDto manager) {
		super();
		this.id = id;
		this.prjet_id = prjet_id;
		this.titre = titre;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.status = status;
		this.admin = admin;
		this.manager = manager;
	}
	public List<TacheDto> getTaches() {
		return taches;
	}
	public void setTaches(List<TacheDto> taches) {
		this.taches = taches;
	}
	public AdminDto getAdmin() {
		return admin;
	}

	public void setAdmin(AdminDto admin) {
		this.admin = admin;
	}
	public ManagerDto getManager() {
		return manager;
	}
	public void setManager(ManagerDto manager) {
		this.manager = manager;
	}
	public List<Avancemen_ProjettDto> getAvancementsProjet() {
		return avancementsProjet;
	}
	public void setAvancementsProjet(List<Avancemen_ProjettDto> avancementsProjet) {
		this.avancementsProjet = avancementsProjet;
	}
	/*
	public List<TacheDto> getTaches() {
		return taches;
	}
	public void setTaches(List<TacheDto> taches) {
		this.taches = taches;
	}*/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public ProjetDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
