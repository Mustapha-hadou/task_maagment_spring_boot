package com.example.demo.services.Imp;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Avancemen_ProjettEntity;
import com.example.demo.entities.AvancementTacheEntity;
import com.example.demo.entities.ProjetEntity;
import com.example.demo.entities.TacheEntity;
import com.example.demo.repository.AvancementProjetRepository;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.services.AvancementProjetService;
import com.example.demo.sherd.dto.Avancemen_ProjettDto;
import com.example.demo.sherd.dto.ProjetDto;
import com.example.demo.sherd.dto.TacheDto;

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

	    ProjetEntity projetEntity=projetRepository.findByProjetId(id_Projet);
		
		Type listType=new TypeToken<ProjetDto>() {}.getType();
		ProjetDto projetdto=new ModelMapper().map(projetEntity,listType);
		
		avanProjetDto.setProjet(projetdto);	
		
		Type listTypeA=new TypeToken<Avancemen_ProjettEntity>() {}.getType();
		Avancemen_ProjettEntity avanprojetEntity=new ModelMapper().map(avanProjetDto,listTypeA);
		
		String status = "" ;
		if(avanprojetEntity.getScore() != 0) {
			status = "Under Processing";
			if(avanprojetEntity.getScore() == 100) {
				status = "Finished";
			}
			projetEntity.setStatus(status);
			projetRepository.save(projetEntity);
		}
	    avancementProjetRepository.save(avanprojetEntity);
	}

	
	
	
}
