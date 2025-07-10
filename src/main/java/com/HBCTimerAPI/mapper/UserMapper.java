package com.HBCTimerAPI.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.HBCTimerAPI.domain.entities.User;
import com.HBCTimerAPI.dto.user.UserResponseDTO;

public class UserMapper {

	public static User toEntity(User dto) {
		return new User(null, dto.getName(), dto.getEmail(), dto.getPassword());
	}
	
	public static UserResponseDTO toDTO(User user) {
		UserResponseDTO dto = new UserResponseDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		return dto;
	}
	
	public static List<UserResponseDTO> toDTOList(List<User> user){
		return user.stream()
		.map(UserMapper::toDTO)
		.collect(Collectors.toList());
	}
	
	
	
}
