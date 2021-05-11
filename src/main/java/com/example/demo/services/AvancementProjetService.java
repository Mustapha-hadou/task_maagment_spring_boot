package com.example.demo.services;

import java.util.List;

import com.example.demo.sherd.dto.Avancemen_ProjettDto;


public interface AvancementProjetService {

	
    List<Avancemen_ProjettDto> getAvancementProjetByidProjet(String idProjet);
	
	void createAvancementProjet(Avancemen_ProjettDto avanProjetDto,String id_Projet);
	
}
