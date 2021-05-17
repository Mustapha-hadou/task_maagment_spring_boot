package com.example.demo.services;



import java.security.Principal;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.sherd.dto.ProjetDto;
import com.example.demo.sherd.dto.UserDto;


public interface UserService extends UserDetailsService {

	void createUser(UserDto userDto,String email);
	UserDto getUser(String email);
	UserDto getUserByUserId(String userid);
	UserDto UpdateUser(String id,UserDto userDto);
	void deleteUser(String userid);
	void createUser(UserDto userDto);
	List<UserDto> getAllUsers();
}
