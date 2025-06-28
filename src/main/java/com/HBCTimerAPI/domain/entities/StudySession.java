package com.HBCTimerAPI.domain.entities;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_study_session")
public class StudySession {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private Instant date;
	private Duration totalTimeOfDay = Duration.ZERO;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private User student;
	
	@OneToMany(mappedBy = "id.session", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StudyTracker> items = new ArrayList<>();
	
	public StudySession() {
		
	}

	public StudySession(Long id, Instant date, Duration totalTimeDate, User student) {
		super();
		this.id = id;
		this.date = date;
		this.totalTimeOfDay = totalTimeDate;
		this.student = student;
	}

	
	public Long getId() {
		return id;
	}
	public Instant getDate() {
		return date;
	}

	public Duration getTotalTimeOfDay() {
		return totalTimeOfDay;
	}

	public User getStudent() {
		return student;
	}
	
	public List<StudyTracker> getItems() {
		return items;
	}

	public void setTotalTimeOfDay(Duration total) {
		this.totalTimeOfDay = total;
	}
	
	public void addTracker(StudyTracker tracker) {
	    items.add(tracker);
	    totalTimeOfDay = totalTimeOfDay.plus(tracker.getTotalTime());
	}
	
	public void updateTotalTimeOfDay() {
	    this.totalTimeOfDay = items.stream()
	        .map(StudyTracker::getTotalTime)
	        .reduce(Duration.ZERO, Duration::plus);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudySession other = (StudySession) obj;
		return Objects.equals(id, other.id);
	}
}
