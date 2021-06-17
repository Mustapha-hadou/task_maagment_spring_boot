package com.example.demo.controllers;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repances.ProjetResponse;
import com.example.demo.requests.MessageRequest;
import com.example.demo.requests.TacheRequest;
import com.example.demo.services.MessageService;
import com.example.demo.services.ProjetService;
import com.example.demo.services.UserService;
import com.example.demo.sherd.dto.MessageDto;
import com.example.demo.sherd.dto.ProjetDto;
import com.example.demo.sherd.dto.TacheDto;
import com.example.demo.sherd.dto.UserDto;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService message;

	@Autowired
	UserService user;
	@Autowired
	ProjetService projetService;
	
	@GetMapping
	public ResponseEntity<List<ProjetResponse>> getProjetByDedlain() {
		projetService.getProjetByDedlain();
		
		return null;
	}
	
}
