package com.HBCTimerAPI.services;

import java.time.LocalDate;
import java.time.ZoneId;
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
	
	public StudyTracker createStudyTracker(StudyTrackerRequestDTO dto) {
		Matter matter = matterRepo.findById(dto.getMatterId()).orElseThrow();
		
	
		//extrai a data do starTime do DDTO
		LocalDate trackerDate = dto.getStartTime()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		
		Optional<StudySession> optionalSession = 
				sessionRepo.findByStudentAndDate(matter.getStudent(), trackerDate);
		
		
		
		StudySession session = optionalSession.orElseGet(() -> {
			StudySession newSession = new StudySession();
			newSession.setDate(trackerDate);
			newSession.setStudent(matter.getStudent());
			newSession.setTotalTimeOfDay(0L);
			return sessionRepo.save(newSession);
		});
		
		
		
		StudyTracker tracker = StudyTrackerMapper.toEntity(dto, matter, session);
		StudyTracker savedTracker = studyTrackerRepo.save(tracker);
		
		
		session.addTracker(savedTracker);
		session.updateTotalTimeOfDay();
		sessionRepo.save(session);
		
		return savedTracker;
	}
	
	public void deleteById(Long id) {
		StudyTracker tracker = studyTrackerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));//recupera a tracker que deseja apagar
		
		StudySession session = tracker.getSession(); //chama o studysession pegando a sessão que está vinculada ao tracker
		
		session.getItems().remove(tracker); //chama a lista de trackers(items) que estão relacionada a essa session 
		
		session.updateTotalTimeOfDay(); //atualiza o totaltimeofday
		
		sessionRepo.save(session); //persiste a session 
		
		studyTrackerRepo.delete(tracker); //e deleta em definitivo a tracker informada
	}
	
	public List<StudyTracker> findAll(){
		return studyTrackerRepo.findAll();
	}
	
	public StudyTracker update(Long id, StudyTracker obj){
		StudyTracker tracker = studyTrackerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
		updateData(tracker, obj);
		
		StudySession session = tracker.getSession(); //chama o studysession pegando a sessão que está vinculada ao tracker
		
		session.updateTotalTimeOfDay(); //atualiza o totaltimeofday
		
		sessionRepo.save(session); //persiste a session 
		
		
		return studyTrackerRepo.save(tracker);
	}
	
	private void updateData(StudyTracker tracker, StudyTracker obj) {
		tracker.setStartTime(obj.getStartTime());
		tracker.setEndTime(obj.getEndTime());
	}
}
