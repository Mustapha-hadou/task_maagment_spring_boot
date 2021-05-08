package com.example.demo.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repances.UserRepance;
import com.example.demo.requests.UesrRequest;
import com.example.demo.services.UserService;
import com.example.demo.sherd.dto.UserDto;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping(path="/{id}")
	public UserRepance getUser(@PathVariable String id ) {
		
		UserDto userDto = userService.getUserByUserId(id);
		UserRepance userReponse = new UserRepance();
		
		BeanUtils.copyProperties(userDto, userReponse);
		
		return userReponse;
	}
	
	
	@PostMapping
	public void createUser(@RequestBody UesrRequest userRequest) {
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);
		userService.createUser(userDto);
		
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
		userService.deleteUser(id);;
	}

}
