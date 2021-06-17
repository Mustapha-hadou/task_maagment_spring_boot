package com.example.demo.services;

import java.util.Date;

public interface MailService {
	
	public void send(String from, String to, String subject, String body);
    public void transactionMail(String to, String subject, String body);
    public void sendMail(String email, String link);

}
