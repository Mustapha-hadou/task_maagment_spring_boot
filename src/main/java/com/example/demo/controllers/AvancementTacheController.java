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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repances.AvancementTacheResponse;
import com.example.demo.requests.AvancementTacheRequest;
import com.example.demo.services.AvancementTacheService;
import com.example.demo.sherd.dto.AvancementTacheDto;

@RestController
@RequestMapping("/avancementTache")
public class AvancementTacheController {

	@Autowired
	AvancementTacheService avancementTacheService;
	
	@GetMapping(path="/{idTache}")
	public ResponseEntity<List<AvancementTacheResponse>> getAvancementTache(@PathVariable String idTache) {
		
		List<AvancementTacheDto> dtoTaches=avancementTacheService.getAvancementTacheByidTache(idTache);
		
		Type listType=new TypeToken<List<AvancementTacheResponse>>() {}.getType();
		List<AvancementTacheResponse> avancementTache=new ModelMapper().map(dtoTaches,listType);
		
		return new ResponseEntity<List<AvancementTacheResponse>>(avancementTache,HttpStatus.OK) ;
	}
	
	@PostMapping(path="/{idTache}")
	public void createAvancementTache(AvancementTacheRequest avan,@PathVariable String idTache) {


		Type listType=new TypeToken<AvancementTacheDto>() {}.getType();
		AvancementTacheDto avancementTache=new ModelMapper().map(avan,listType);
		
		avancementTacheService.createAvancementTache(avancementTache,idTache);
		
	
	}
	
	
}
