package com.example.demo.controllers;

import java.lang.reflect.Type;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ProjetEntity;
import com.example.demo.entities.TacheEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.repances.ProjetResponse;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.TacheRepository;
import com.example.demo.requests.MessageRequest;
import com.example.demo.requests.TacheRequest;
import com.example.demo.services.MailService;
import com.example.demo.services.MessageService;
import com.example.demo.services.ProjetService;
import com.example.demo.services.UserService;
import com.example.demo.sherd.dto.MessageDto;
import com.example.demo.sherd.dto.ProjetDto;
import com.example.demo.sherd.dto.TacheDto;
import com.example.demo.sherd.dto.UserDto;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService message;

	@Autowired
	UserService user;
	@Autowired
	ProjetService projetService;
	@Autowired
    private MailService mailService;
	@Autowired
	ProjetRepository projetRepository;
	
	@Autowired
	TacheRepository tacheRepository;
	@GetMapping
	public void getProjetByDedlain() {
    List<ProjetEntity> projets = projetRepository.findAll();
		
		for(int i = 0; i < projets.size(); i++) {
			if(projets.get(i).getStatus() != "Finished" && projets.get(i).getStatus() != "Cancelled") {
				long millis = projets.get(i).getDate_fin().getTime();
				
				System.out.println(projets.get(i).getDate_fin().getTime()  - System.currentTimeMillis());
				if(System.currentTimeMillis() - projets.get(i).getDate_fin().getTime() == 172800000) {
					mailService.send(projets.get(i).getAdmin().getEmail(),projets.get(i).getManager().getEmail(), "finaliser Projet", "salut ! , " +projets.get(i).getManager().getNom()
					        + "\n\n il vous reste moins de deux jours pour finir projet de "+projets.get(i).getTitre());
				}
				if(System.currentTimeMillis() - projets.get(i).getDate_fin().getTime() == 0) {
					String status = "" ;
					if(!projets.get(i).getStatus().equals("Finished")){
						status = "Cancelled";
						projets.get(i).setStatus(status);
						projetRepository.save(projets.get(i));
					}
				}
				
					
			}
				
		}
		
		
	}
	
	@GetMapping(path="/tache")
	public void getTacheByDedlain() {
    List<TacheEntity> taches = tacheRepository.findAll();
		
		for(int i = 0; i < taches.size(); i++) {
			if(taches.get(i).getStatus() != "Finished" & taches.get(i).getStatus() != "Cancelled") {
				long millis = taches.get(i).getDate_fin().getTime();
				
				System.out.println(taches.get(i).getDate_fin().getTime()  - System.currentTimeMillis());
				if(System.currentTimeMillis() - taches.get(i).getDate_fin().getTime() < 172800000) {
					mailService.send(taches.get(i).getManager().getEmail(),taches.get(i).getEmployee().getEmail(), "finaliser tache", "salut ! , " +taches.get(i).getEmployee().getNom()
					        + "\n\n il vous reste moins de deux jours pour finir la tache de "+taches.get(i).getTitre());
					System.out.println("okk");
				}
				
				if(System.currentTimeMillis() - taches.get(i).getDate_fin().getTime() < 0) {
					String status = "" ;
					if(!taches.get(i).getStatus().equals("Finished")){
						status = "Cancelled";
						taches.get(i).setStatus(status);
						tacheRepository.save(taches.get(i));
					}
				}
				
					
			}
				
		}
	}
	

	@PostMapping(path="/envoiyeMessage")
	public void MessageEnvoye(@RequestBody MessageRequest msg,Principal principal) {
		
         System.out.print(msg.getEmail_rec());
		mailService.send(principal.getName(),msg.getEmail_rec(), msg.getObjet(),msg.getContenu() );
		}
	
}
