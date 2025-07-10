package com.HBCTimerAPI.dto.studyTracker;

import java.time.Duration;
import java.time.Instant;

public class StudyTrackerResponseDTO {

	private Long id;
	private Instant startTime;
	private Instant endTime;
	private Boolean isActive;
	private Long matterId;
	private Long sessionId;
	private Duration subTotalTime;
	
	public StudyTrackerResponseDTO() {
		
	}
	
	public StudyTrackerResponseDTO(Long id, Long matterId, Long sessionId, Instant startTime, Instant endTime, Duration subTotalTime, Boolean isActive) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isActive = isActive;
		this.matterId = matterId;
		this.sessionId = sessionId;
		this.subTotalTime = subTotalTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getStartTime() {
		return startTime;
	}

	public void setStartTime(Instant startTime) {
		this.startTime = startTime;
	}

	public Instant getEndTime() {
		return endTime;
	}

	public void setEndTime(Instant endTime) {
		this.endTime = endTime;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getMatterId() {
		return matterId;
	}

	public void setMatterId(Long matterId) {
		this.matterId = matterId;
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public Duration getSubTotalTime() {
		return subTotalTime;
	}

	public void setSubTotalTime(Duration subTotalTime) {
		this.subTotalTime = subTotalTime;
	}
}

