package com.example.demo.services;

import java.util.List;


import com.example.demo.sherd.dto.ProjetDto;
import com.example.demo.sherd.dto.TacheDto;


public interface ProjetService {
	
	List<ProjetDto> getAllProjets();
	void createProjet(ProjetDto projetDto,String email,String idManager);
	ProjetDto getProjet(String projetId);
	List<ProjetDto> getProjetManager(String manager_id);
	//List<ProjetDto> getProjetAdmin(String admin_id);
	void deleteProjet(String projetId);
	List<ProjetDto> getProjetAdmin(String email);
	
}
