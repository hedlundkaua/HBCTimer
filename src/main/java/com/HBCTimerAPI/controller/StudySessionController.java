package com.HBCTimerAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HBCTimerAPI.domain.entities.StudySession;
import com.HBCTimerAPI.services.StudySessionService;

@RestController
@RequestMapping(value = "/session")
public class StudySessionController {

	@Autowired
	private StudySessionService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudySession> findById(@PathVariable Long id){
		StudySession obj = service.findByid(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
