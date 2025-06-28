package com.HBCTimerAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HBCTimerAPI.domain.entities.DailyGoal;
import com.HBCTimerAPI.services.DailyGoalService;

@RestController
@RequestMapping(value = "/goals")
public class DailyGoalController {

	
	@Autowired
	private DailyGoalService service;
	
	@GetMapping
	public ResponseEntity<List<DailyGoal>> findAll(){
		List<DailyGoal> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DailyGoal> findById(@PathVariable Long id){
		DailyGoal obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
