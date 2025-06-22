package com.HBCTimerAPI.model.entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

import com.HBCTimerAPI.model.entities.pk.StudyTrackerPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_studys")
public class StudyTracker implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StudyTrackerPK id = new StudyTrackerPK();
	
	
	private Instant startTime;
	private Instant endTime;
	private Boolean isActive;	
	
	public StudyTracker() {
		
	}
	
	public StudyTracker(Matter matter, StudySession session, Instant startTime, Instant endTime, Boolean isActive) {
		super();
		id.setMatter(matter);
		id.setSession(session);
		this.startTime = startTime;
		this.endTime = endTime;
		this.isActive = isActive;
	}
	
	@JsonIgnore
	public Matter getMatter() {
		return id.getMatter();
	}
	
	@JsonIgnore
	public StudySession getSession() {
		return id.getSession();
	}
	public Instant getStart() {
		return startTime;
	}
	public Instant getEnd() {
		return endTime;
	}
	public Duration getTotalTime() {
	    if(startTime != null && endTime != null) {
	    	return Duration.between(startTime, endTime);
	    }
	    return Duration.ZERO;
	}
	public Boolean getIsActive() {
		return isActive;
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
		StudyTracker other = (StudyTracker) obj;
		return Objects.equals(id, other.id);
	}
}
