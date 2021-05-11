package com.example.demo.services.Imp;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Avancemen_ProjettEntity;
import com.example.demo.entities.ProjetEntity;
import com.example.demo.repository.AvancementProjetRepository;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.services.AvancementProjetService;
import com.example.demo.sherd.dto.Avancemen_ProjettDto;

@Service
public class AvancementProjetServiceImpl implements AvancementProjetService{
	
	@Autowired
	AvancementProjetRepository avancementProjetRepository;
	
	@Autowired
	ProjetRepository projetRepository;

	@Override
	public List<Avancemen_ProjettDto> getAvancementProjetByidProjet(String idProjet) {

	    ProjetEntity projetEntity=projetRepository.findByProjetId(idProjet);
		
		List<Avancemen_ProjettEntity> avancement=avancementProjetRepository.findByProjet(projetEntity);
		
		
		Type listType=new TypeToken<List<Avancemen_ProjettDto>>() {}.getType();
		List<Avancemen_ProjettDto> avancementprojetResponse=new ModelMapper().map(avancement,listType);
				
		return avancementprojetResponse;
	}

	@Override
	public void createAvancementProjet(Avancemen_ProjettDto avanProjetDto, String id_Projet) {

		
	}

	
	
	
}
