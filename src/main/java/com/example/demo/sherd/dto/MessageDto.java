package com.example.demo.sherd.dto;

import java.util.Date;

public class MessageDto {

	private String contenu;
	private Date date_envoie;
	private UserDto admin;
	private UserDto manager;
	private String  objet;
	
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDate_envoie() {
		return date_envoie;
	}
	public void setDate_envoie(Date date_envoie) {
		this.date_envoie = date_envoie;
	}
	public UserDto getAdmin() {
		return admin;
	}
	public void setAdmin(UserDto admin) {
		this.admin = admin;
	}
	public UserDto getManager() {
		return manager;
	}
	public void setManager(UserDto manager) {
		this.manager = manager;
	}
	public MessageDto(String contenu, Date date_envoie, UserDto admin, UserDto manager, String objet) {
		super();
		this.contenu = contenu;
		this.date_envoie = date_envoie;
		this.admin = admin;
		this.manager = manager;
		this.objet = objet;
	}
	public MessageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}	
	
}
