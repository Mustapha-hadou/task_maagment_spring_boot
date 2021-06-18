package com.example.demo.services.Imp;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AvancementTacheEntity;
import com.example.demo.entities.TacheEntity;
import com.example.demo.repository.AvancementTacheRepository;
import com.example.demo.repository.TacheRepository;
import com.example.demo.services.AvancementTacheService;
import com.example.demo.sherd.dto.TacheDto;
import com.example.demo.sherd.dto.AvancementTacheDto;

@Service
public class AvancementTacheServiceImpl  implements AvancementTacheService {


	@Autowired
	AvancementTacheRepository avancementTacheRepository;
	
	@Autowired
	TacheRepository tacheRepository;

	@Override
	public List<AvancementTacheDto> getAvancementTacheByidTache(String idTache) {
		
		TacheEntity tacheEntity=tacheRepository.findByTacheId(idTache);
		
		List<AvancementTacheEntity> avancement=avancementTacheRepository.findByTache(tacheEntity);
		
		
		Type listType=new TypeToken<List<AvancementTacheDto>>() {}.getType();
		List<AvancementTacheDto> avancementtacheResponse=new ModelMapper().map(avancement,listType);
				
		return avancementtacheResponse;
	}

	@Override
	public void createAvancementTache(AvancementTacheDto avantacheDto,String id_tache) {

		TacheEntity tacheEntity=tacheRepository.findByTacheId(id_tache);
		
		Type listType=new TypeToken<TacheDto>() {}.getType();
		TacheDto tachedto=new ModelMapper().map(tacheEntity,listType);
		
		avantacheDto.setTache(tachedto);
		
		Type listTypeA=new TypeToken<AvancementTacheEntity>() {}.getType();
		AvancementTacheEntity avantacheEntity=new ModelMapper().map(avantacheDto,listTypeA);
		
		String status = "" ;
		if(avantacheEntity.getScore() != 0) {
			status = "Under Processing";
			System.out.println("pro");
			if(avantacheEntity.getScore() == 100) {
				status = "Finished";
				System.out.println("fini");
			}
			tacheEntity.setStatus(status);
			tacheRepository.save(tacheEntity);
			
		}
		
		
	    avancementTacheRepository.save(avantacheEntity);
	}

	
}
