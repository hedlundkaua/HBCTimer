package com.HBCTimerAPI.controller;

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

	private final StudySessionService sessionService;
	
	public StudySessionController(StudySessionService sessionService) {
		this.sessionService = sessionService;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<StudySession> findById(@PathVariable Long id){
		StudySession obj = sessionService.findByid(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
}
