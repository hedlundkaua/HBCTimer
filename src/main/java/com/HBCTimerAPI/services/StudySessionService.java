package com.HBCTimerAPI.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HBCTimerAPI.domain.entities.StudySession;
import com.HBCTimerAPI.repository.StudySessionRepository;

@Service
public class StudySessionService {
	
	
	 private final StudySessionRepository repository;
	 
	 public StudySessionService(StudySessionRepository repository) {
		 this.repository = repository;
	 }
	 
	 public StudySession findByid(Long id) {
		Optional<StudySession> obj = repository.findById(id);
		return obj.get();
	 }
	 
	 public void deleteById(Long id) {
		 repository.deleteById(id);
	 }
	 
}
