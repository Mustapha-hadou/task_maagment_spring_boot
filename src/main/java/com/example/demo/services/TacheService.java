package com.example.demo.services;

import java.util.List;


import com.example.demo.sherd.dto.TacheDto;

public interface TacheService {

	void createTache(TacheDto tacheDto,String email,Long idEmploye,Long idProjet);
	
	List<TacheDto> getTacheByidProjet(int idProjet);
	
	List<TacheDto> getTacheByidEmploye(String idemploye);

	
	
	
}
