package com.example.demo.services.Imp;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ProjetEntity;
import com.example.demo.entities.TacheEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.TacheRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.TacheService;
import com.example.demo.sherd.Utils;
import com.example.demo.sherd.dto.ProjetDto;
import com.example.demo.sherd.dto.TacheDto;
import com.example.demo.sherd.dto.UserDto;
//import com.example.demo.sherd.dto.avancementTacheDto;

@Service
public class TacheServiceImpl implements TacheService{

	@Autowired
	TacheRepository tacheRepository;

	
	
	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	ProjetRepository projetRepository;
	
	 @Autowired
	 Utils util;
	    
	
	@Override
	public void createTache(TacheDto tacheDto,String email,Long idEmploye,Long idProjet) {

		UserEntity manager=userRepository.findByEmail(email);		

		
		Type listType=new TypeToken<UserDto>() {}.getType();
		UserDto managerDto=new ModelMapper().map(manager,listType);
		
		
        Optional<UserEntity> employe=userRepository.findById(idEmploye);	

		UserDto employeDto=new ModelMapper().map(employe,listType);

        Optional<ProjetEntity> projet=projetRepository.findById(idProjet);

		Type listTypeP=new TypeToken<ProjetDto>() {}.getType();
		ProjetDto projetDto=new ModelMapper().map(projet,listTypeP);

		
        tacheDto.setProjet(projetDto);
		tacheDto.setManager(managerDto);
		tacheDto.setEmploye(employeDto);
		
 
		TacheEntity tacheEntity = new TacheEntity();
		BeanUtils.copyProperties(tacheDto, tacheEntity);	
		
		tacheEntity.setTache_id(util.generateStringId(32));
		
		
		tacheRepository.save(tacheEntity);
		
	}


	

	@Override
	public List<TacheDto> getTacheByidEmploye(String idemploye) {
		
		UserEntity userEntity=userRepository. findByUserId(idemploye);
		List<TacheEntity> listTaches=tacheRepository.findByEmployee(userEntity);
		

		Type listType=new TypeToken<List<TacheDto>>() {}.getType();
		List<TacheDto>  listesTchesDto=new ModelMapper().map(listTaches,listType);
		
		return listesTchesDto;
	}




	@Override
	public List<TacheDto> getTacheByidProjet(int idProjet) {

		//ProjetEntity projetEntity=projetRepository.findById(idProjet);
				//tacheRepository.findByProjet(projetEntity);
				
		return null;
	}

}
