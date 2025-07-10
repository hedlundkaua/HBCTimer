package com.HBCTimerAPI.dto.matter;

import java.util.ArrayList;
import java.util.List;

import com.HBCTimerAPI.domain.entities.StudyTracker;
import com.HBCTimerAPI.dto.user.UserResponseDTO;

public class MatterResponseDTO {

	private Long id;
	private String name;
	private String description;
	
	private UserResponseDTO userResponseDTO;
	
	private List<StudyTracker> studies = new ArrayList<>();

	
	public MatterResponseDTO(Long id, String name, String description, UserResponseDTO userResponseDTO, List<StudyTracker> studies) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.userResponseDTO = userResponseDTO;
		this.studies = studies;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public UserResponseDTO getUser() {
		return userResponseDTO;
	}
	
	public List<StudyTracker> getStudies() {
		return studies;
	}
}
