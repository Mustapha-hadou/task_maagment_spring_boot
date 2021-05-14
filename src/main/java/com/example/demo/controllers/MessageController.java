package com.example.demo.controllers;

import java.lang.reflect.Type;
import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.requests.MessageRequest;
import com.example.demo.requests.TacheRequest;
import com.example.demo.services.MessageService;
import com.example.demo.services.UserService;
import com.example.demo.sherd.dto.MessageDto;
import com.example.demo.sherd.dto.TacheDto;
import com.example.demo.sherd.dto.UserDto;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService message;

	@Autowired
	UserService user;
	
	
	
	@PostMapping(path="/{idmanager}")
	public void createMessage(@RequestBody MessageRequest messageRequest,Principal principal,@PathVariable  String idmanager) {		
		
		Type listType=new TypeToken<MessageDto>() {}.getType();
		MessageDto  messageDto=new ModelMapper().map(messageRequest,listType);
		
		UserDto manager = user.getUserByUserId(idmanager);
		
		messageDto.setManager(manager);
		
		UserDto admin = user.getUserByUserId(principal.getName());
		
		messageDto.setAdmin(admin);
		
		message.sendEmail(messageDto);
		message.createMessage(messageDto);
	}
	
	
}
