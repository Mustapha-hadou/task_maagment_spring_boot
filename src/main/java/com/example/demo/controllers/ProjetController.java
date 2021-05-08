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
import com.example.demo.repances.ProjetResponse;
import com.example.demo.requests.ProjetRequest;
import com.example.demo.services.ProjetService;
import com.example.demo.sherd.dto.ProjetDto;

@RestController
@RequestMapping("/projets")
public class ProjetController {
	@Autowired
	ProjetService projetService;
	
	@GetMapping
	public ResponseEntity<List<ProjetResponse>>getProjets(){
		List<ProjetDto> projets = projetService.getAllProjets();
		Type listeType = new TypeToken<List<ProjetResponse>>() {}.getType();
		List<ProjetResponse> projetsResponse = new ModelMapper().map(projets,listeType);
		return new ResponseEntity<List<ProjetResponse>>(projetsResponse , HttpStatus.OK);
	}
	
	@PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity storeProjet(@RequestBody ProjetRequest projetRequest,Principal principal,Principal principal2){

        ModelMapper modelMapper=new ModelMapper();

        ProjetDto projetDto=modelMapper.map(projetRequest,ProjetDto.class);
        ProjetDto createProjet=projetService.createProjet(projetDto,principal.getName(),principal2.getName());

        ProjetResponse newProjet=modelMapper.map(createProjet,ProjetResponse.class);

        return new ResponseEntity(newProjet,HttpStatus.CREATED);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<ProjetResponse> getOneProjet(@PathVariable(name="id") String projetId) {
		ProjetDto projectDto = projetService.getProjet(projetId);
		
		ModelMapper modelMapper = new ModelMapper();
		
		ProjetResponse projectResponse = modelMapper.map(projectDto, ProjetResponse.class);
		
		return new ResponseEntity<ProjetResponse>(projectResponse , HttpStatus.OK);
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
