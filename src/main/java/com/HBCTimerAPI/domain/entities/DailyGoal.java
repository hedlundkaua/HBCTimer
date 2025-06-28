package com.HBCTimerAPI.domain.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_dailyGoal")
public class DailyGoal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant date;
	private Instant time;
	
	public DailyGoal() {
	}
	
	public DailyGoal(Long id, Instant date, Instant time) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public Instant getDate() {
		return date;
	}

	public Instant getTime() {
		return time;
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
		DailyGoal other = (DailyGoal) obj;
		return Objects.equals(id, other.id);
	}
	
}
