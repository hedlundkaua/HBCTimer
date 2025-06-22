package com.HBCTimerAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HBCTimerAPI.model.entities.StudyTracker;

public interface StudyTrackerRepository extends JpaRepository<StudyTracker, Long>{

}
