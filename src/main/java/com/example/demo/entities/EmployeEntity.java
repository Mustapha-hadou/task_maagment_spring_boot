package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "employee")
public class EmployeEntity extends UserEntity {
	
	

	@ManyToOne
	@JoinColumn()
	AdminEntity admin ;
	
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	List<TacheEntity> taches;

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

	public EmployeEntity(long id, String userId, String nom, String prenom, String email, String telephone, int age,
			String encryptepassword, String emailVerificationToken, Boolean emailVerificationStatus, String role,
			AdminEntity admin, List<TacheEntity> taches) {
		super(id, userId, nom, prenom, email, telephone, age, encryptepassword, emailVerificationToken,
				emailVerificationStatus, role);
		this.admin = admin;
		this.taches = taches;
	}
	
	
	
	
	
	
	

}
