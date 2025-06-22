package com.HBCTimerAPI.model.entities;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
	private Duration totalTimeDate;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private User student;
	
	@OneToMany(mappedBy = "id.session")
	private Set<StudyTracker> items = new HashSet<>();
	
	public StudySession() {
		
	}

	public StudySession(Long id, Instant date, Duration totalTimeDate, User student) {
		super();
		this.id = id;
		this.date = date;
		this.totalTimeDate = totalTimeDate;
		this.student = student;
	}

	
	public Long getId() {
		return id;
	}
	public Instant getDate() {
		return date;
	}

	public Duration getTotalTimeDate() {
		return totalTimeDate;
	}

	public User getStudent() {
		return student;
	}

	public Set<StudyTracker> getItems() {
		return items;
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
