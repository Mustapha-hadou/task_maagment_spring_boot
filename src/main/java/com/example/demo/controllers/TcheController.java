package com.example.demo.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ProjetEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.repances.AvancementTacheResponse;
import com.example.demo.repances.TacheResponse;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.requests.TacheRequest;
import com.example.demo.requests.UesrRequest;
import com.example.demo.services.AvancementTacheService;
import com.example.demo.services.MailService;
import com.example.demo.services.TacheService;
import com.example.demo.services.UserService;
import com.example.demo.sherd.dto.AvancementTacheDto;
import com.example.demo.sherd.dto.TacheDto;
import com.example.demo.sherd.dto.UserDto;

import java.lang.reflect.Type;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tache")
public class TcheController {
	
	
	@Autowired
	TacheService tacheService;
	
	@Autowired
	AvancementTacheService avancementTacheService;
	@Autowired
    private MailService mailService;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProjetRepository projetRepository;
	
	@GetMapping(path="/{idProjet}")
	public ResponseEntity<List<TacheResponse>> getTachesProjet(@PathVariable String idProjet) {
		
		
		List<TacheDto> dtoTaches=tacheService.getTacheByidProjet(idProjet);
		
		Type listType=new TypeToken<List<TacheResponse>>() {}.getType();
		List<TacheResponse> tacheResponse=new ModelMapper().map(dtoTaches,listType);
		
		return new ResponseEntity<List<TacheResponse>>(tacheResponse,HttpStatus.OK) ;
	}
	
	@PostMapping(path="/{idEmploye}/{idProjet}")
	public void createTache(@RequestBody TacheRequest tacheRequest,Principal principal,@PathVariable  String idEmploye,@PathVariable String idProjet) {	
		
		Type listType=new TypeToken<TacheDto>() {}.getType();
		TacheDto  tacheDto=new ModelMapper().map(tacheRequest,listType);
		
		System.out.print(principal.getName());
		
		tacheService.createTache(tacheDto,principal.getName(),idEmploye,idProjet);
		
		UserEntity employe =  userRepository.findByUserId(idEmploye);
		ProjetEntity projet =  projetRepository.findByProjetId(idProjet);
		
		mailService.send(principal.getName(),employe.getEmail(), "Affectation d'un tache", "Hello, " + employe.getNom()
        + "\n\n vous êtes affectee a une nouvelle  tache . \n"
        + "\n projet: "+projet.getTitre()
        + "\n votre tache : "+tacheDto.getTitre()
        + "\n descruption de tache :"+tacheDto.getDescription()
        + "\n date de remise: "+tacheDto.getDate_fin()
        + "\n Merci.");
	}
	
	@GetMapping(path="/getTacheEmploye")
	public ResponseEntity<List<TacheResponse>> getTachesEmployes(Principal idEmploye) {
		
		List<TacheDto> dtoTaches=tacheService.getTacheByidEmploye(idEmploye.getName());
		Type listType=new TypeToken<List<TacheResponse>>() {}.getType();
		List<TacheResponse> tacheResponse=new ModelMapper().map(dtoTaches,listType);
		

		for(int i=0;i<tacheResponse.size();i++) {
			tacheResponse.get(i).setProjet(dtoTaches.get(i).getProjet().getTitre());
			tacheResponse.get(i).setManager(dtoTaches.get(i).getProjet().getManager().getNom());

			String id=tacheResponse.get(i).getTache_id();
			
			List<AvancementTacheDto> listeAvancement=avancementTacheService.getAvancementTacheByidTache(id);
		
			
			
			Type listType2=new TypeToken<List<AvancementTacheResponse>>() {}.getType();
			List<AvancementTacheResponse> avancementTacheResponse=new ModelMapper().map(listeAvancement,listType2);
			

			tacheResponse.get(i).setAvancementTache(avancementTacheResponse);
		}
		
		return new ResponseEntity<List<TacheResponse>>(tacheResponse,HttpStatus.OK) ;
	}
	
	
}
