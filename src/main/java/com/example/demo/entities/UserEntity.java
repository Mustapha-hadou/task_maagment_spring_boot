package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Entity(name="user")

public class UserEntity implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	private long Id;
	
	@Column
	private String userId;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private int age;
	private String encryptepassword;
	private String emailVerificationToken;
	private Boolean emailVerificationStatus;
	private String role;

	public UserEntity(long id, String userId, String nom, String prenom, String email, String telephone, int age,
			String encryptepassword, String emailVerificationToken, Boolean emailVerificationStatus,String role) {
		super();
		Id = id;
		this.userId = userId;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.age = age;
		this.encryptepassword = encryptepassword;
		this.emailVerificationToken = emailVerificationToken;
		this.emailVerificationStatus = emailVerificationStatus;
		this.role=role;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEncryptepassword() {
		return encryptepassword;
	}
	public void setEncryptepassword(String encryptepassword) {
		this.encryptepassword = encryptepassword;
	}
	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}
	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}
	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}
	public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
