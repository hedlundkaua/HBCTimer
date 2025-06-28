package com.HBCTimerAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HBCTimerAPI.domain.entities.StudyTracker;

public interface StudyTrackerRepository extends JpaRepository<StudyTracker, Long>{

}
