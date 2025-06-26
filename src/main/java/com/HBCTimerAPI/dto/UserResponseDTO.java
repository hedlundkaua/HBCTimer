package com.HBCTimerAPI.dto;

import java.util.ArrayList;
import java.util.List;

import com.HBCTimerAPI.model.entities.User;

public class UserResponseDTO {

	private Long id;
	private String name;
	private String email;
	
	
	
	private UserResponseDTO(Long id,String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public static UserResponseDTO transformaEmDTO(User user) {
		return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
		
		
	}

	public static List<UserResponseDTO> transformaVariosEmDTO(List<User> list) {
		List<UserResponseDTO> listResponseDTO = new ArrayList<>();
		for(User u : list) {
			listResponseDTO.add( new UserResponseDTO(u.getId(), u.getName(), u.getEmail()));
		}
		return listResponseDTO;
	}
}
