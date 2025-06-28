package com.HBCTimerAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HBCTimerAPI.dto.user.UserProfileDTO;
import com.HBCTimerAPI.dto.user.UserResponseDTO;
import com.HBCTimerAPI.model.entities.User;
import com.HBCTimerAPI.services.UserService;

@RestController

@RequestMapping(value = "/users")
public class UserController {

	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> findAll(){ 
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(UserResponseDTO.transformaVariosEmDTOSemSenha(list)); //esta retornando uma lista
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(UserResponseDTO.transformaEmDTOSemSenha(obj));
	}
		
	@PostMapping
	public ResponseEntity<UserResponseDTO> insert(@RequestBody UserProfileDTO obj){
		User user = service.insert(obj.criaObjeto());
		return ResponseEntity.ok().body(UserResponseDTO.transformaEmDTOSemSenha(user));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<User> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
		user = service.update(id, user);
		return ResponseEntity.ok().body(user);
	}
}
