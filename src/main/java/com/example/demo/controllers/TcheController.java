package com.example.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tache")
public class TcheController {

	
	@GetMapping
	public String getTache() {
		return "get";
	}
	
	
	@PostMapping
	public String createTache() {
		return "post";
	}
	
	@PutMapping
	public String updateTache() {
		return "put";
	}
	
	@DeleteMapping
	public String deleteTache() {
		return "delet";
	}
}
