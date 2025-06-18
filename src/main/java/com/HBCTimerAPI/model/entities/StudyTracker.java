package com.HBCTimerAPI.model.entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_studys")
public class StudyTracker implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant startTime;
	private Instant endTime;
	private Duration totalTime;
	private Boolean isActive;
	

	
	public StudyTracker() {
		
	}
	
	public StudyTracker(Long id, Instant start, Instant end, Duration totalTime, Boolean isActive) {
		super();
		this.id = id;
		this.startTime = start;
		this.endTime = end;
		this.totalTime = totalTime;
		this.isActive = isActive;
	}
	
	
	public Long getId() {
		return id;
	}
	public Instant getStart() {
		return startTime;
	}
	public Instant getEnd() {
		return endTime;
	}
	public Duration getTotalTime() {
		return totalTime;
	}
	public Boolean getIsActive() {
		return isActive;
	}
}
