package com.example.demo.repances;

import java.util.Date;
import java.util.List;

import com.example.demo.sherd.dto.UserDto;

public class TacheResponse {

	
	private String titre;
	private String description;
	private Date date_debut;
	private Date date_fin;
	private String status;
	private String tache_id;
	private UserRepance employee;
    private List<AvancementTacheResponse> avancementTache;	
	
	
    
    
	public UserRepance getEmployee() {
		return employee;
	}

	public void setEmployee(UserRepance employee) {
		this.employee = employee;
	}

	public List<AvancementTacheResponse> getAvancementTache() {
		return avancementTache;
	}

	public void setAvancementTache(List<AvancementTacheResponse> avancementTache) {
		this.avancementTache = avancementTache;
	}

	public TacheResponse(String titre, String description, Date date_debut, Date date_fin, String status,
			String tache_id, UserRepance employee, List<AvancementTacheResponse> avancementTache) {
		super();
		this.titre = titre;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.status = status;
		this.tache_id = tache_id;
		this.employee = employee;
		this.avancementTache = avancementTache;
	}

	public TacheResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getTache_id() {
		return tache_id;
	}
	public void setTache_id(String tache_id) {
		this.tache_id = tache_id;
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
