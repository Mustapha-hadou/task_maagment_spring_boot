package com.example.demo.controllers;


import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.example.demo.repances.Avancemen_ProjettResponse;
import com.example.demo.repances.AvancementTacheResponse;
import com.example.demo.repances.ProjetResponse;
import com.example.demo.repances.TacheResponse;
import com.example.demo.repances.UserRepance;
import com.example.demo.requests.ProjetRequest;
import com.example.demo.requests.TacheRequest;
import com.example.demo.services.AvancementProjetService;
import com.example.demo.services.AvancementTacheService;
import com.example.demo.services.ProjetService;
import com.example.demo.services.TacheService;
import com.example.demo.sherd.dto.Avancemen_ProjettDto;
import com.example.demo.sherd.dto.AvancementTacheDto;
import com.example.demo.sherd.dto.ProjetDto;
import com.example.demo.sherd.dto.TacheDto;

@RestController
@RequestMapping("/projets")
public class ProjetController {
	@Autowired
	ProjetService projetService;
	
	@Autowired
	TacheService tacheService;
	
	@Autowired
	AvancementProjetService avanprojetService;
	

	@Autowired
	AvancementTacheService avancementTacheService;
	
	@GetMapping
	public ResponseEntity<List<ProjetResponse>>getProjets(){
		List<ProjetDto> projets = projetService.getAllProjets();
		Type listeType = new TypeToken<List<ProjetResponse>>() {}.getType();
		List<ProjetResponse> projetsResponse = new ModelMapper().map(projets,listeType);
		return new ResponseEntity<List<ProjetResponse>>(projetsResponse , HttpStatus.OK);
	}
	
	@PostMapping(path="/{idManager}")
	public void createProjet(@RequestBody ProjetRequest projetRequest,Principal principal,@PathVariable  Long idManager) {	
		
		Type listType=new TypeToken<ProjetDto>() {}.getType();
		ProjetDto  projetDto=new ModelMapper().map(projetRequest,listType);
		
		projetService.createProjet(projetDto,principal.getName(),idManager);
		System.out.println(principal.getName() + " " +idManager);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProjetResponse> getOneProjet(@PathVariable(name="id") String projetId) {
		ProjetDto projectDto = projetService.getProjet(projetId);
		
		ModelMapper modelMapper = new ModelMapper();
		
		ProjetResponse projectResponse = modelMapper.map(projectDto, ProjetResponse.class);
		
		return new ResponseEntity<ProjetResponse>(projectResponse , HttpStatus.OK);
	}
	@GetMapping("/{idemploye}")
	public ResponseEntity<List<ProjetResponse>> getProjetByEmploye(@PathVariable(name="idemploye") String employetId) {
		
		List<TacheDto> dtoTaches= tacheService.getTacheByidEmploye(employetId);
		
		List<ProjetDto> projetsDto=null;
		
		for(int i=0;i<dtoTaches.size();i++) {
			
			ProjetDto projectDto=dtoTaches.get(i).getProjet();
			projetsDto.add(projectDto);
		}	
		Type listType2=new TypeToken<List<ProjetResponse>>() {}.getType();
		List<ProjetResponse> projetsResponse=new ModelMapper().map(projetsDto,listType2);
		
		return new ResponseEntity<List<ProjetResponse>>(projetsResponse, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{idmanager}")
	public ResponseEntity<List<ProjetResponse>> getProjetByManager(@PathVariable(name="idmanager") String managerId) {
		
		
		List<ProjetDto> dtoProjets=projetService.getProjetManager(managerId);
				

		Type listType=new TypeToken<List<ProjetResponse>>(){}.getType();
		List<ProjetResponse> responseProjets=new ModelMapper().map(dtoProjets,listType);
		
		for(int i=0;i<responseProjets.size();i++) {
			
			List<Avancemen_ProjettDto> liste=avanprojetService.getAvancementProjetByidProjet(dtoProjets.get(i).getPrjet_id());
			
			Type listType2=new TypeToken<List<Avancemen_ProjettResponse>>(){}.getType();
			List<Avancemen_ProjettResponse> avancementProjetResponse=new ModelMapper().map(liste,listType2);
			
			
			responseProjets.get(i).setAvancementsProjet(avancementProjetResponse);
			
			List<TacheDto> dtoTaches=tacheService.getTacheByidProjet((int)dtoProjets.get(i).getId());

			Type listType3=new TypeToken<List<TacheResponse>>(){}.getType();
			List<TacheResponse> tacheResponse=new ModelMapper().map(dtoTaches,listType3);
			List<UserRepance> listeemloye=null;
			for(int j=0;j<tacheResponse.size();j++) {
				
				String id=tacheResponse.get(i).getTache_id();
				List<AvancementTacheDto> listeAvancement=avancementTacheService.getAvancementTacheByidTache(id);
				
				Type listType4=new TypeToken<List<AvancementTacheResponse>>() {}.getType();
				List<AvancementTacheResponse> avancementTacheResponse=new ModelMapper().map(listeAvancement,listType4);

				tacheResponse.get(i).setListe(avancementTacheResponse);
				listeemloye.add(tacheResponse.get(i).getEmploye());
			}
			
			responseProjets.get(i).setTaches(tacheResponse);
			responseProjets.get(i).setEmployes(listeemloye);
		}	
		return new ResponseEntity<List<ProjetResponse>>(responseProjets, HttpStatus.OK);		
	}
	
	

	@GetMapping("/{idAdmin}")
	public ResponseEntity<List<ProjetResponse>> getProjetByAdmin(@PathVariable(name="idAdmin") String adminId) {
		
		

		List<ProjetDto> dtoProjets=projetService.getProjetAdmin(adminId);
				

		Type listType=new TypeToken<List<ProjetResponse>>(){}.getType();
		List<ProjetResponse> responseProjets=new ModelMapper().map(dtoProjets,listType);
		
		for(int i=0;i<responseProjets.size();i++) {
			
			List<Avancemen_ProjettDto> liste=avanprojetService.getAvancementProjetByidProjet(dtoProjets.get(i).getPrjet_id());
			
			Type listType2=new TypeToken<List<Avancemen_ProjettResponse>>(){}.getType();
			List<Avancemen_ProjettResponse> avancementProjetResponse=new ModelMapper().map(liste,listType2);
			
			
			responseProjets.get(i).setAvancementsProjet(avancementProjetResponse);
		}
	
		return new ResponseEntity<List<ProjetResponse>>(responseProjets, HttpStatus.OK);		
	}	

	@PutMapping("/{id}")
	public ResponseEntity<String> updateProjet(@PathVariable(name="id") String projetId) {
		return new ResponseEntity<>("update projets" , HttpStatus.ACCEPTED);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProjet(@PathVariable(name="id") String projetId) {
		projetService.deleteProjet(projetId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


}
