package com.example.demo.services.Imp;

import java.lang.reflect.Type;
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
	public void createProjet(ProjetDto projetDto,String email,Long idManager) {

		UserEntity admin =userRepository.findByEmail(email);		

		
		Type listType=new TypeToken<UserDto>() {}.getType();
		UserDto adminDto=new ModelMapper().map(admin,listType);
		
		
        Optional<UserEntity> manager=userRepository.findById(idManager);	
        
		UserDto managerDto=new ModelMapper().map(manager,listType);

		
		System.out.println(adminDto.getEmail() + " h" + managerDto.getUserId());
		
		projetDto.setAdmin(adminDto);
		projetDto.setManager(managerDto);
		
 
		ProjetEntity projetEntity = new ProjetEntity();
		BeanUtils.copyProperties(projetDto, projetEntity);	
		
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
		
		UserEntity manager=userRepository.findByUserId(manager_id);
		
		List<ProjetEntity> projetsEntity = projetRepository.findByManager(manager);
		
		Type listeType = new TypeToken<List<ProjetDto>>() {}.getType();
		List<ProjetDto> projetsDto = new ModelMapper().map(projetsEntity,listeType);		
		
		
		return projetsDto;
	}


	@Override
	public List<ProjetDto> getProjetAdmin(String admin_id) {
		
		UserEntity admin=userRepository.findByUserId(admin_id);

	List<ProjetEntity> projetsEntity = projetRepository.findByAdmin(admin);
		
		Type listeType = new TypeToken<List<ProjetDto>>() {}.getType();
		List<ProjetDto> projetsDto = new ModelMapper().map(projetsEntity,listeType);		
		
		
		return projetsDto;
	}

}
