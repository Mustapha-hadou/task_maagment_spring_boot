package com.example.demo.controllers;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repances.Avancemen_ProjettResponse;
import com.example.demo.requests.Avancemen_ProjettRequest;
import com.example.demo.services.AvancementProjetService;
import com.example.demo.sherd.dto.Avancemen_ProjettDto;

@RestController
@RequestMapping("/avancementProjet")
public class AvancementProjetController {

	@Autowired
	AvancementProjetService avancementProjetService;
	
	@GetMapping(path="/{idTache}")
	public ResponseEntity<List<Avancemen_ProjettResponse>> getAvancementProjet(@PathVariable String idProjet) {
		
		List<Avancemen_ProjettDto> dtoTaches=avancementProjetService.getAvancementProjetByidProjet(idProjet);
		
		Type listType=new TypeToken<List<Avancemen_ProjettResponse>>() {}.getType();
		List<Avancemen_ProjettResponse> avancementTache=new ModelMapper().map(dtoTaches,listType);
		
		return new ResponseEntity<List<Avancemen_ProjettResponse>>(avancementTache,HttpStatus.OK) ;
	}
	
	@PostMapping(path="/{idProjet}")
	public void createAvancementProjet(@RequestBody Avancemen_ProjettRequest avan,@PathVariable String idProjet) {
		System.out.print("heyy");

		System.out.print(avan.getTitre());

		Type listType=new TypeToken<Avancemen_ProjettDto>() {}.getType();
		Avancemen_ProjettDto avancementprojet=new ModelMapper().map(avan,listType);
		
		System.out.print(avancementprojet.getTitre());

		
		avancementProjetService.createAvancementProjet(avancementprojet, idProjet);
	
	}
	
	
}
