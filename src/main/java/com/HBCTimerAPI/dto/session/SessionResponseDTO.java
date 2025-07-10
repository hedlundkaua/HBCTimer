package com.HBCTimerAPI.dto.session;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.HBCTimerAPI.domain.entities.StudyTracker;
import com.HBCTimerAPI.dto.user.UserResponseDTO;

public class SessionResponseDTO {
	
	private Long id;
	private LocalDate date;
	private Duration totalTimeOfDate;
	
	private UserResponseDTO student;
	
	private List<StudyTracker> items = new ArrayList<>();

	public SessionResponseDTO() {
		
	}

	public SessionResponseDTO(Long id, LocalDate date, Duration totalTimeOfDate, UserResponseDTO student) {
		this.id = id;
		this.date = date;
		this.totalTimeOfDate = totalTimeOfDate;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Duration getTotalTimeOfDate() {
		return totalTimeOfDate;
	}

	public void setTotalTimeOfDate(Duration totalTimeOfDate) {
		this.totalTimeOfDate = totalTimeOfDate;
	}

	public UserResponseDTO getStudent() {
		return student;
	}

	public void setStudent(UserResponseDTO student) {
		this.student = student;
	}

	public List<StudyTracker> getItems() {
		return items;
	}

	public void setItems(List<StudyTracker> items) {
		this.items = items;
	}
}

