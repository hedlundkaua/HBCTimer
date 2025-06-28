package com.HBCTimerAPI.dto.user;

import com.HBCTimerAPI.domain.entities.User;

public class UserProfileDTO {

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
		return new User(null, name, email, password);
	}	
}
