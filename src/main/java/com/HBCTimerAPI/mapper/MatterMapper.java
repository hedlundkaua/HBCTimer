package com.HBCTimerAPI.mapper;


import java.util.List;
import java.util.stream.Collectors;

import com.HBCTimerAPI.domain.entities.Matter;
import com.HBCTimerAPI.domain.entities.User;
import com.HBCTimerAPI.dto.matter.MatterProfileDTO;
import com.HBCTimerAPI.dto.matter.MatterResponseDTO;
import com.HBCTimerAPI.dto.user.UserResponseDTO;

public class MatterMapper {
	
	public static Matter toEntity(MatterProfileDTO dto, User user) {
		return new Matter(null, dto.getName(), dto.getDescription(), user);
	}
	
	public static MatterResponseDTO toDTO(Matter entity) {
		return new MatterResponseDTO(
				entity.getId(),
				entity.getName(),
				entity.getDescription(),
				UserResponseDTO.transformaEmDTOSemSenha(entity.getStudent()),
				entity.getStudies());
		}
	
	public static List<MatterResponseDTO> toDTOList(List<Matter> entities){
		return entities.stream()
				.map(MatterMapper::toDTO)
				.collect(Collectors.toList());
	}
}
