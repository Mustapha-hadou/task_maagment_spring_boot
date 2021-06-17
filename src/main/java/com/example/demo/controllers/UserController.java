package com.example.demo.controllers;

import java.io.Console;
import java.lang.reflect.Type;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repances.ProjetResponse;
import com.example.demo.repances.UserRepance;
import com.example.demo.requests.UesrRequest;
import com.example.demo.services.ProjetService;
import com.example.demo.services.TacheService;
import com.example.demo.services.UserService;
import com.example.demo.sherd.dto.ProjetDto;
import com.example.demo.sherd.dto.TacheDto;
import com.example.demo.sherd.dto.UserDto;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	ProjetService projetService;
	
	@Autowired
	TacheService tacheService;
	
	
	@GetMapping(path="/{id}")
	public UserRepance getUser(@PathVariable String id ) {
		
		UserDto userDto = userService.getUserByUserId(id);
		UserRepance userReponse = new UserRepance();
		
		BeanUtils.copyProperties(userDto, userReponse);
		
		return userReponse;
	}
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserRepance>>getUsers(){
		List<UserDto> users = userService.getAllUsers();
		Type listeType = new TypeToken<List<UserRepance>>() {}.getType();
		List<UserRepance> usersResponse = new ModelMapper().map(users,listeType);
		return new ResponseEntity<List<UserRepance>>(usersResponse , HttpStatus.OK);
	}
	
	
	@PostMapping
	public void createUser(@RequestBody UesrRequest userRequest,Principal principal) {
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);
		if(principal != null) {
			userService.createUser(userDto,principal.getName());
		}else {
			userService.createUser(userDto);
		}	
		
	}
	
	@PutMapping(path="/{id}")
	public UserRepance updateUser(@PathVariable String id,@RequestBody UesrRequest userRequest) {
		UserDto userDto = userService.getUserByUserId(id);
		
		BeanUtils.copyProperties(userRequest, userDto);
		UserRepance userReponse = new UserRepance();
		
		UserDto userupdate = userService.UpdateUser(id,userDto);
		
		BeanUtils.copyProperties(userupdate, userReponse);
		
		return userReponse;
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
	
	@GetMapping("getEmployeParTaches/{idProjet}")
	public  ResponseEntity<List<UserRepance>> getEmployeParTaches(@PathVariable String idProjet) {
		
		List<UserDto> ALLemployes = userService.getAllEmployees();
		
		
		//ProjetDto projet=projetService.getProjet(idProjet);
		
		List<TacheDto> listesTache=tacheService.getTacheByidProjet(idProjet);
		
		List<String> EmployeNonDisp=new ArrayList();

		for(int i=0;i<listesTache.size();i++) {
			
			EmployeNonDisp.add(listesTache.get(i).getEmployee().getEmail());
			
		}

		int taille=ALLemployes.size();
		
		List<UserDto> EmployeDisp=new ArrayList();

        for(int i=0;i<taille;i++) {
        	
        	if(!EmployeNonDisp.contains(ALLemployes.get(i).getEmail())) { 
        		
        		EmployeDisp.add(ALLemployes.get(i));
        	}	
		}
        
        Type listeType = new TypeToken<List<UserRepance>>() {}.getType();
		List<UserRepance> ALLemployesResp = new ModelMapper().map(EmployeDisp,listeType);
        
		System.out.print(ALLemployesResp.size());
		return new ResponseEntity<List<UserRepance>>(ALLemployesResp , HttpStatus.OK);
		
	}
	
	
	

}
