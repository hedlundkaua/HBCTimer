package com.HBCTimerAPI.dto.matter;

import com.HBCTimerAPI.domain.entities.Matter;
import com.HBCTimerAPI.domain.entities.User;

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

	public Matter criaObjeto(User user) {
		return new Matter(null, this.name, this.description, user);
	}
}
