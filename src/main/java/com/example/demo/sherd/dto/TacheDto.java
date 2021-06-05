package com.example.demo.sherd.dto;

import java.util.Date;
import java.util.List;

import com.example.demo.repances.AvancementTacheResponse;

public class TacheDto {

	

	private long Id;
	private String tache_Id;
	private String titre;
	private String description;
	private Date date_debut;
	private Date date_fin;
	private String status;
	private UserDto employee;
	private UserDto manager;
	private ProjetDto projet;
	private List<AvancementTacheDto> avancementTache;	

	

	
	public UserDto getEmployee() {
		return employee;
	}
	public void setEmployee(UserDto employee) {
		this.employee = employee;
	}
	public List<AvancementTacheDto> getListe() {
		return avancementTache;
	}
	public void setListe(List<AvancementTacheDto> liste) {
		this.avancementTache = liste;
	}
	public String getTache_Id() {
		return tache_Id;
	}
	public void setTache_Id(String tache_Id) {
		this.tache_Id = tache_Id;
	}
	public UserDto getManager() {
		return manager;
	}
	public void setManager(UserDto manager) {
		this.manager = manager;
	}
	public ProjetDto getProjet() {
		return projet;
	}
	public void setProjet(ProjetDto projet) {
		this.projet = projet;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
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
	public TacheDto(long id, String tache_Id, String titre, String description, Date date_debut, Date date_fin,
			String status, UserDto employe, UserDto manager, ProjetDto projet, List<AvancementTacheDto> liste) {
		super();
		Id = id;
		this.tache_Id = tache_Id;
		this.titre = titre;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.status = status;
		this.employee = employe;
		this.manager = manager;
		this.projet = projet;
		this.avancementTache = liste;
	}
	public TacheDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
