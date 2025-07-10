package com.HBCTimerAPI.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HBCTimerAPI.domain.entities.StudySession;
import com.HBCTimerAPI.domain.entities.User;

public interface StudySessionRepository extends JpaRepository<StudySession, Long>{

	Optional<StudySession> findByStudentAndDate(User user, LocalDate date);
	
}
