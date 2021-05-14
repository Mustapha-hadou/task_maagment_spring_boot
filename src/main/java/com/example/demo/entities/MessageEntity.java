package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "message")
public class MessageEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String messageId;
	private String contenu;
	private Date date_envoie;
	
	
	@ManyToOne
	@JoinColumn()
	AdminEntity admin;
	

	@ManyToOne
	@JoinColumn()
	ManagerEntity manager;
	
	
}