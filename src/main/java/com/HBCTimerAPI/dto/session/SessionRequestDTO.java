package com.HBCTimerAPI.dto.session;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.HBCTimerAPI.domain.entities.StudyTracker;
import com.HBCTimerAPI.domain.entities.User;

public class SessionRequestDTO {

	private Long id;
	private LocalDate date;
	private Long totalTimeOfDay;
	
	private User student;
	
	private List<StudyTracker> items = new ArrayList<>();
	
	public SessionRequestDTO() {
		
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
	public Long getTotalTimeOfDay() {
		return totalTimeOfDay;
	}
	public void setTotalTimeOfDay(Long totalTimeOfDay) {
		this.totalTimeOfDay = totalTimeOfDay;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public List<StudyTracker> getItems() {
		return items;
	}
	public void setItems(List<StudyTracker> items) {
		this.items = items;
	}	
}
