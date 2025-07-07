package com.HBCTimerAPI.dto.user;

public class UserResponseDTO {

	private Long id;
	private String name;
	private String email;
	
	public UserResponseDTO() {
		
	}
	
	
	public UserResponseDTO(Long id,String name, String email) {
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
	
	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setEmail(String email) {
		this.email = email;
	}
}
