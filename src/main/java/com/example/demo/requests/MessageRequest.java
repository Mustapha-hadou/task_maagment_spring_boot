package com.example.demo.requests;

import java.util.Date;

public class MessageRequest {


	private String contenu;
	private Date date_envoie;
	private String objet;
	private String email_rec;
	
	
	
	public String getEmail_rec() {
		return email_rec;
	}
	public void setEmail_rec(String email_rec) {
		this.email_rec = email_rec;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public MessageRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MessageRequest(String contenu, Date date_envoie, String objet, String email_rec) {
		super();
		this.contenu = contenu;
		this.date_envoie = date_envoie;
		this.objet = objet;
		this.email_rec = email_rec;
	}
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


}
