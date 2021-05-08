package com.example.demo.sherd.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long Id;
	private String userId;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String telephone;
	private int age;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private String encryptepassword;
	private String emailVerificationToken;
	private Boolean emailVerificationStatus;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(long id, String userId, String nom, String prenom, String email, String password, String telephone,
			int age, String encryptepassword, String emailVerificationToken, Boolean emailVerificationStatus) {
		super();
		Id = id;
		this.userId = userId;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.age = age;
		this.encryptepassword = encryptepassword;
		this.emailVerificationToken = emailVerificationToken;
		this.emailVerificationStatus = emailVerificationStatus;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	

}
