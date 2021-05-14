package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.services.MessageService;
import com.example.demo.sherd.dto.MessageDto;
import com.example.demo.sherd.dto.UserDto;

@SpringBootApplication
public class MiniProjetSpringApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MiniProjetSpringApplication.class, args);
		
	}
	@Bean
	public  BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}
}
