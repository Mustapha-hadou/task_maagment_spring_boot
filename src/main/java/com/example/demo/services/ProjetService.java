package com.example.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.entities.ProjetEntity;
import com.example.demo.sherd.dto.ProjetDto;

public interface ProjetService {
	
	List<ProjetDto> getAllProjets();
	ProjetDto createProjet(ProjetDto projet, String email_admin , String email_manager);
	ProjetDto getProjet(String projetId);
	void deleteProjet(String projetId);
}
