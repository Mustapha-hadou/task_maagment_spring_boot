package com.example.demo.requests;

import java.util.Date;

public class MessageRequest {


	private String contenu;
	private Date date_envoie;
	private String objet;
	
	
	
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
	public MessageRequest(String contenu, Date date_envoie, String objet) {
		super();
		this.contenu = contenu;
		this.date_envoie = date_envoie;
		this.objet = objet;
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
