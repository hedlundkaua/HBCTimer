package com.HBCTimerAPI.dto;

import com.HBCTimerAPI.model.entities.User;

public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private String password;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public User criaObjeto() {
		return new User(id, name, email, password);
	}	
}
