package com.example.demo.services.Imp;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AdminEntity;
import com.example.demo.entities.ManagerEntity;
import com.example.demo.entities.ProjetEntity;
import com.example.demo.entities.TacheEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.ProjetService;
import com.example.demo.sherd.Utils;
import com.example.demo.sherd.dto.ProjetDto;
import com.example.demo.sherd.dto.TacheDto;
import com.example.demo.sherd.dto.UserDto;

@Service
public class ProjetServiceImpl implements ProjetService{
	
	@Autowired
	ProjetRepository projetRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@Autowired
    Utils util;
	
	@Override
	public List<ProjetDto> getAllProjets() {
		List<ProjetEntity> projets = (List<ProjetEntity>) projetRepository.findAll();
		
		Type listeType = new TypeToken<List<ProjetDto>>() {}.getType();
		List<ProjetDto> projetsDto = new ModelMapper().map(projets,listeType);
		
		return projetsDto;
	}
     
	@Override
	public void createProjet(ProjetDto projetDto,String email,String idManager) {

		AdminEntity admin =(AdminEntity) userRepository.findByEmail(email);		

		ManagerEntity manager=(ManagerEntity) userRepository.findByUserId(idManager);	
        
		
		Type listType2=new TypeToken<ProjetEntity>() {}.getType();
		ProjetEntity projetEntity=new ModelMapper().map(projetDto,listType2);
		
		projetEntity.setAdmin(admin);
		projetEntity.setManager(manager);		

		projetEntity.setPrjet_id(util.generateStringId(32));	
		
		projetRepository.save(projetEntity);
		
	}

	@Override
	public ProjetDto getProjet(String projetId) {
		ProjetEntity projetEntity = projetRepository.findByProjetId(projetId);
		ModelMapper modelMapper = new ModelMapper();
		ProjetDto projetDto = modelMapper.map(projetEntity, ProjetDto.class);
		return projetDto;
	}


	@Override
	public void deleteProjet(String projetId) {
		ProjetEntity projet = projetRepository.findByProjetId(projetId);
		if(projet == null ) throw new RuntimeException("Projet Not Found");
		projetRepository.delete(projet);
	}


	@Override
	public List<ProjetDto> getProjetManager(String manager_id) {
		
		UserEntity manager=userRepository.findByEmail(manager_id);
		//UserEntity manager=userRepository.findByUserId(manager_id);
		System.out.print(manager.getEmail());
		List<ProjetEntity> projetsEntity = projetRepository.findByManager(manager);
		System.out.print(projetsEntity.size());

		Type listeType = new TypeToken<List<ProjetDto>>() {}.getType();
		List<ProjetDto> projetsDto = new ModelMapper().map(projetsEntity,listeType);		
		System.out.print(projetsDto.size());

		
		return projetsDto;
	}

/*
	@Override
	public List<ProjetDto> getProjetAdmin(String admin_id) {
		
		UserEntity admin=userRepository.findByUserId(admin_id);

	List<ProjetEntity> projetsEntity = projetRepository.findByAdmin(admin);
		
		Type listeType = new TypeToken<List<ProjetDto>>() {}.getType();
		List<ProjetDto> projetsDto = new ModelMapper().map(projetsEntity,listeType);		
		
		
		return projetsDto;
	}*/
	
	@Override
	public List<ProjetDto> getProjetAdmin(String email) {
		
		UserEntity admin=userRepository.findByEmail(email);

	List<ProjetEntity> projetsEntity = projetRepository.findByAdmin(admin);
		
		Type listeType = new TypeToken<List<ProjetDto>>() {}.getType();
		List<ProjetDto> projetsDto = new ModelMapper().map(projetsEntity,listeType);		
		
		
		return projetsDto;
	}

	

}
