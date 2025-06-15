package com.HBCTimerAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HBCTimerAPI.model.entities.DailyGoal;
import com.HBCTimerAPI.repository.DailyGoalRepository;

@Service
public class DailyGoalService {

	@Autowired
	private DailyGoalRepository repository;
	
	
	public List<DailyGoal> findAll(){
		return repository.findAll();
	}
	
	public DailyGoal findById(Long id) {
		Optional<DailyGoal> obj = repository.findById(id);
		return obj.get();
	}
	
}
