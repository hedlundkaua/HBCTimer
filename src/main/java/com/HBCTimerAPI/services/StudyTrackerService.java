package com.HBCTimerAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HBCTimerAPI.model.entities.StudyTracker;
import com.HBCTimerAPI.repository.StudyTrackerRepository;

@Service
public class StudyTrackerService {

	@Autowired
	private StudyTrackerRepository repository;
	
	public List<StudyTracker> findAll(){
		 return repository.findAll();
	}
	
	public StudyTracker findById(Long id) {
		Optional<StudyTracker> obj = repository.findById(id);
		return obj.get();
	}
	
}
