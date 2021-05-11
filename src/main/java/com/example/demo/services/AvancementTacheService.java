package com.example.demo.services;

import java.util.List;

import com.example.demo.sherd.dto.AvancementTacheDto;


public interface AvancementTacheService {

	List<AvancementTacheDto> getAvancementTacheByidTache(String idTache);
	
	void createAvancementTache(AvancementTacheDto avantacheDto,String id_tache);

}
