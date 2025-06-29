package com.HBCTimerAPI.dto.user;

import java.util.ArrayList;
import java.util.List;

import com.HBCTimerAPI.domain.entities.User;

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

	public static UserResponseDTO transformaEmDTOSemSenha(User user) {
		return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
		
	}

	public static List<UserResponseDTO> transformaVariosEmDTOSemSenha(List<User> list) {
		List<UserResponseDTO> listResponseDTO = new ArrayList<>();
		for(User u : list) {
			listResponseDTO.add( new UserResponseDTO(u.getId(), u.getName(), u.getEmail()));
		}
		return listResponseDTO;
	}
}
