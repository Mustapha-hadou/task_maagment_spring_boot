package com.example.demo.services;



import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.sherd.dto.UserDto;

public interface UserService extends UserDetailsService {

	void createUser(UserDto userDto);
	UserDto getUser(String email);
	UserDto getUserByUserId(String userid);
	UserDto UpdateUser(String id,UserDto userDto);
	void deleteUser(String userid);
}
