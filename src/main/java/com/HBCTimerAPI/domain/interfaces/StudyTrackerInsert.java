package com.HBCTimerAPI.domain.interfaces;

import org.springframework.http.ResponseEntity;

import com.HBCTimerAPI.dto.studyTracker.StudyTrackerRequestDTO;
import com.HBCTimerAPI.dto.studyTracker.StudyTrackerResponseDTO;

public interface StudyTrackerInsert {

	public ResponseEntity<StudyTrackerResponseDTO> insert(StudyTrackerRequestDTO dto);
	
}
