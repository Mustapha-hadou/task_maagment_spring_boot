package com.example.demo.services.Imp;

import java.lang.reflect.Type;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AdminEntity;
import com.example.demo.entities.ManagerEntity;
import com.example.demo.entities.ProjetEntity;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.ProjetService;
import com.example.demo.sherd.Utils;
import com.example.demo.sherd.dto.ProjetDto;
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
	public ProjetDto createProjet(ProjetDto projet, String email_admin, String email_manager) {
		AdminEntity admin = (AdminEntity) userRepository.findByEmail(email_admin);
		ManagerEntity Manager = (ManagerEntity) userRepository.findByEmail(email_manager);
		
		ModelMapper modelMapper=new ModelMapper();
        UserDto adminDto = modelMapper.map(admin,UserDto.class);
        UserDto managerDto = modelMapper.map(Manager,UserDto.class);
        
        projet.setPrjet_id(util.generateStringId(30));
        projet.setAdmin(adminDto);
        projet.setManager(managerDto);

        ProjetEntity proejtEntity=modelMapper.map(projet,ProjetEntity.class);
        ProjetEntity newProjet=projetRepository.save(proejtEntity);
        ProjetDto projetDto=modelMapper.map(newProjet,ProjetDto.class);
        return projetDto;
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
		if(projet == null ) throw new RuntimeException("Address Not Found");
		projetRepository.delete(projet);
	}

}
