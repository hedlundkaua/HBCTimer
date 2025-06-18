package com.HBCTimerAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HBCTimerAPI.model.entities.StudyTracker;
import com.HBCTimerAPI.services.StudyTrackerService;

@RestController
@RequestMapping(value = "/study")
public class StudyTrackerController {

	@Autowired
	private StudyTrackerService service;
	
	@GetMapping
	public ResponseEntity<List<StudyTracker>> findAll(){
		List<StudyTracker> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudyTracker> findById(@PathVariable Long id){
		StudyTracker obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
