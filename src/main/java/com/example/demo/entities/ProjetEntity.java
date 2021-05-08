package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity(name = "projet")
public class ProjetEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String prjet_id;
	private String titre;
	private String description;
	private Date date_debut;
	private Date date_fin;
	private String status;
	private String document;
	
	@ManyToOne
	@JoinColumn()
	AdminEntity admin;
	
	@OneToMany(mappedBy = "projet",cascade = CascadeType.ALL)
	List<TacheEntity> taches;
	
	@ManyToOne
	@JoinColumn()
	ManagerEntity manager;
	
	@OneToMany(mappedBy = "projet",cascade = CascadeType.ALL)
	List<Avancemen_ProjettEntity> avancementsProjet;
	
	
	

	public ProjetEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjetEntity(Long id, String prjet_id, String titre, String description, Date date_debut, Date date_fin,
			String status, String document, AdminEntity admin, List<TacheEntity> taches, ManagerEntity manager,
			List<Avancemen_ProjettEntity> avancementsProjet) {
		super();
		this.id = id;
		this.prjet_id = prjet_id;
		this.titre = titre;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.status = status;
		this.document = document;
		this.admin = admin;
		this.taches = taches;
		this.manager = manager;
		this.avancementsProjet = avancementsProjet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public AdminEntity getAdmin() {
		return admin;
	}

	public void setAdmin(AdminEntity admin) {
		this.admin = admin;
	}

	public List<TacheEntity> getTaches() {
		return taches;
	}

	public void setTaches(List<TacheEntity> taches) {
		this.taches = taches;
	}

	public ManagerEntity getManager() {
		return manager;
	}

	public void setManager(ManagerEntity manager) {
		this.manager = manager;
	}
	
	
	
	

}
