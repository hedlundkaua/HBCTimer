package com.HBCTimerAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HBCTimerAPI.model.entities.User;
import com.HBCTimerAPI.services.UserService;

@RequestMapping("/users")
@RestController
public class UserController {

	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){ 
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); //esta retornando uma lista
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	
	
}
