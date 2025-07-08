package com.HBCTimerAPI.domain.entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private Boolean isActive;	
	
	@ManyToOne
	@JoinColumn(name = "matter_id")
	private Matter matter;
	
	@ManyToOne
	@JoinColumn(name = "session_id")
	private StudySession session;
	
	public StudyTracker() {
		
	}
	
	public StudyTracker(Matter matter, StudySession session, Instant startTime, Instant endTime, Boolean isActive) {
		this.matter = matter;
		this.session = session;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}
	@JsonIgnore
	public Matter getMatter() {
		return matter;
	}
	
	@JsonIgnore
	public StudySession getSession() {
		return session;
	}
	
	public Instant getStartTime() {
		return startTime;
	}
	
	public Instant getStart() {
		return startTime;
	}
	public Instant getEnd() {
		return endTime;
	}
	
	public Instant getEndTime() {
		return endTime;
	}

	public void setEndTime(Instant endTime) {
		this.endTime = endTime;
	}

	public void setStartTime(Instant startTime) {
		this.startTime = startTime;
	}

	public Duration getTotalTime() {
		//verifica se o inicio e o fim são diferentes de nulos, caso de verdadeiro ele calcula o tempo de estudos
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
