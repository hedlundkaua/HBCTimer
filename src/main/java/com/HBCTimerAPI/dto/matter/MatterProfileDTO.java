package com.HBCTimerAPI.dto.matter;

public class MatterProfileDTO {
	
	private String name;
	private String description;
	
	private Long userId;
	

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Long getUserId() {
		return userId;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
