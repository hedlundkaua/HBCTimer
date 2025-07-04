package com.HBCTimerAPI.domain.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_matter")
public class Matter implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private User student;
	
	
	@OneToMany(mappedBy = "matter")
	private List<StudyTracker> studies = new ArrayList<>();
	
	public Matter() {
	}
	
	public Matter(Long id, String name, String description, User student) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.student = student;
	}
	
	
	public List<StudyTracker> getStudies() {
		return studies;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public User getStudent() {
		return student;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
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
		Matter other = (Matter) obj;
		return Objects.equals(id, other.id);
	}
}
