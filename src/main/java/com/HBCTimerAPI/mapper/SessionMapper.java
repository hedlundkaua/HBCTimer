package com.HBCTimerAPI.mapper;

import com.HBCTimerAPI.domain.entities.StudySession;
import com.HBCTimerAPI.dto.session.SessionRequestDTO;
import com.HBCTimerAPI.dto.session.SessionResponseDTO;

public class SessionMapper {

	public static StudySession toEntity(SessionRequestDTO dto) {
		return new StudySession(dto.getDate(), dto.getTotalTimeOfDay(), dto.getStudent());
	}
	
	public static SessionResponseDTO toDTO(StudySession session) {
		SessionResponseDTO dto = new SessionResponseDTO();
		dto.setId(session.getId());
		dto.setDate(session.getDate());
		dto.setTotalTimeOfDate(session.getTotalTimeOfDay());
		dto.setStudent(UserMapper.toDTO(session.getStudent()));
		dto.setItems(session.getItems());
		return dto;
	}
}
