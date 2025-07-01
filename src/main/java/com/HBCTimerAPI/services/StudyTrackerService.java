package com.HBCTimerAPI.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.HBCTimerAPI.domain.entities.StudyTracker;
import com.HBCTimerAPI.repository.StudyTrackerRepository;
import com.HBCTimerAPI.services.exceptions.ResourceNotFoundException;

public class StudyTrackerService {

	@Autowired
	private StudyTrackerRepository repository;
	
	
	public StudyTracker findById(Long id) {
		Optional<StudyTracker> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	
}
