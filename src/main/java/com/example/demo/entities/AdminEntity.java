package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity(name = "admin")
public class AdminEntity extends UserEntity {
	
	@Id
	@GeneratedValue
	private long Id;
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	@Column
	private String dept;

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public List<EmployeEntity> getEmployes() {
		return employes;
	}

	public void setEmployes(List<EmployeEntity> employes) {
		this.employes = employes;
	}

	public List<ProjetEntity> getProjets() {
		return projets;
	}

	public void setProjets(List<ProjetEntity> projets) {
		this.projets = projets;
	}

	public List<ManagerEntity> getManagers() {
		return managers;
	}

	public void setManagers(List<ManagerEntity> managers) {
		this.managers = managers;
	}

	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
	List<EmployeEntity> employes ;
	
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
	List<ProjetEntity> projets ;
	
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
	List<ManagerEntity> managers;

	public AdminEntity(long id, String userId, String nom, String prenom, String email, String telephone, int age,
			String encryptepassword, String emailVerificationToken, Boolean emailVerificationStatus, String role,
			List<EmployeEntity> employes, List<ProjetEntity> projets, List<ManagerEntity> managers) {
		super(id, userId, nom, prenom, email, telephone, age, encryptepassword, emailVerificationToken,
				emailVerificationStatus, role);
		this.employes = employes;
		this.projets = projets;
		this.managers = managers;
	}

	
}
