package com.HBCTimerAPI.dto.matter;

import java.util.HashSet;
import java.util.Set;

import com.HBCTimerAPI.domain.entities.StudyTracker;
import com.HBCTimerAPI.dto.user.UserResponseDTO;

public class MatterResponseDTO {

	private Long id;
	private String name;
	private String description;
	
	private UserResponseDTO user;
	
	private Set<StudyTracker> studies = new HashSet<>();

	
	public MatterResponseDTO(Long id, String name, String description, UserResponseDTO user, Set<StudyTracker> studies) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.user = user;
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
		return user;
	}
	
	public Set<StudyTracker> getStudies() {
		return studies;
	}

	/*
	public static MatterResponseDTO transformaMatterEmDTO(Matter m) {
		return new MatterResponseDTO(m.getId(), m.getName(), m.getDescription(), UserResponseDTO.transformaEmDTOSemSenha(m.getStudent()), m.getStudies());
	}
	
	public static List<MatterResponseDTO> transfromaVariosMatterEmDTO(List<Matter> matter){
		List<MatterResponseDTO> mrDTO = new ArrayList<>();
		for(Matter m : matter) {
			mrDTO.add(new MatterResponseDTO(m.getId(), m.getName(), m.getDescription(), UserResponseDTO.transformaEmDTOSemSenha(m.getStudent()), m.getStudies()));		
		}
		return mrDTO;	
	}*/
}
