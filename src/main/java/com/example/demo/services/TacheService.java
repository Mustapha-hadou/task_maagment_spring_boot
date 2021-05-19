package com.example.demo.services;

import java.util.List;


import com.example.demo.sherd.dto.TacheDto;

public interface TacheService {

	void createTache(TacheDto tacheDto,String email,String idEmploye,String idProjet);
	
	List<TacheDto> getTacheByidProjet(int idProjet);
	
	List<TacheDto> getTacheByidEmploye(String idemploye);

	
	
	
}
