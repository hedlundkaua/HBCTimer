package com.HBCTimerAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HBCTimerAPI.domain.entities.Matter;
import com.HBCTimerAPI.domain.entities.StudySession;
import com.HBCTimerAPI.domain.entities.StudyTracker;
import com.HBCTimerAPI.dto.studyTracker.StudyTrackerRequestDTO;
import com.HBCTimerAPI.mapper.StudyTrackerMapper;
import com.HBCTimerAPI.repository.MatterRepository;
import com.HBCTimerAPI.repository.StudySessionRepository;
import com.HBCTimerAPI.repository.StudyTrackerRepository;
import com.HBCTimerAPI.services.exceptions.ResourceNotFoundException;

@Service
public class StudyTrackerService {

	
	//injeção de dependencia 
	private final StudyTrackerRepository studyTrackerRepo;
	private final StudySessionRepository sessionRepo;	
	private final MatterRepository matterRepo;
	
	public StudyTrackerService(StudySessionRepository session, StudyTrackerRepository trackerRepo, MatterRepository matterRepo) {
		this.sessionRepo = session;
		this.studyTrackerRepo = trackerRepo;
		this.matterRepo = matterRepo;
	}
	
	
	public StudyTracker findById(Long id) {
		Optional<StudyTracker> obj = studyTrackerRepo.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public StudyTracker insert(StudyTrackerRequestDTO dto) {
		StudySession session = sessionRepo.findById(dto.getSessionId()).orElseThrow();
		Matter matter = matterRepo.findById(dto.getMatterId()).orElseThrow();
		
		StudyTracker tracker = StudyTrackerMapper.toEntity(dto, matter, session);
		StudyTracker savedTracker = studyTrackerRepo.save(tracker);
		
		
		session.addTracker(savedTracker);
		session.updateTotalTimeOfDay();
		sessionRepo.save(session);
		
		return savedTracker;
	}
	
	public List<StudyTracker> findAll(){
		return studyTrackerRepo.findAll();
	}
	
	
}
