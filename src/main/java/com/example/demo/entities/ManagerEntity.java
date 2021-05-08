package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity(name = "manager")
public class ManagerEntity extends UserEntity {
	
	@ManyToOne
	@JoinColumn()
	AdminEntity admin ;
	
	@OneToMany(mappedBy = "manager",cascade = CascadeType.ALL)
	List<TacheEntity> taches;
	
	@OneToMany(mappedBy = "manager",cascade = CascadeType.ALL)
	List<ProjetEntity> projets;

	public ManagerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManagerEntity(long id, String userId, String nom, String prenom, String email, String telephone, int age,
			String encryptepassword, String emailVerificationToken, Boolean emailVerificationStatus, String role) {
		super(id, userId, nom, prenom, email, telephone, age, encryptepassword, emailVerificationToken, emailVerificationStatus,
				role);
		// TODO Auto-generated constructor stub
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

	public List<ProjetEntity> getProjets() {
		return projets;
	}

	public void setProjets(List<ProjetEntity> projets) {
		this.projets = projets;
	}
	
	

}
