package com.HBCTimerAPI.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.HBCTimerAPI.domain.entities.Matter;
import com.HBCTimerAPI.domain.entities.StudySession;
import com.HBCTimerAPI.domain.entities.StudyTracker;
import com.HBCTimerAPI.dto.studyTracker.StudyTrackerRequestDTO;
import com.HBCTimerAPI.dto.studyTracker.StudyTrackerResponseDTO;

public class StudyTrackerMapper {

	public static StudyTracker toEntity(StudyTrackerRequestDTO dto, Matter matter, StudySession session) {
		return new StudyTracker(
				matter,
				session,
				dto.getStartTime(),
				dto.getEndTime(), 
				false);
	}
	
	
	public static StudyTrackerResponseDTO toDTO(StudyTracker tracker) {
		StudyTrackerResponseDTO dto = new StudyTrackerResponseDTO();
		dto.setId(tracker.getId());
		dto.setMatterId(tracker.getMatter().getId());
		dto.setSessionId(tracker.getSession().getId());
		dto.setStartTime(tracker.getStartTime());
		dto.setEndTime(tracker.getEnd());
		dto.setIsActive(tracker.getIsActive());
		return dto;
	}
	
	public static List<StudyTrackerResponseDTO> toDTOList(List<StudyTracker> entities) {
		return entities.stream()
		.map(StudyTrackerMapper::toDTO)
		.collect(Collectors.toList());
	}
	
}
