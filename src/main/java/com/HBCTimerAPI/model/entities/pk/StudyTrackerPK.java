package com.HBCTimerAPI.model.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.HBCTimerAPI.domain.entities.Matter;
import com.HBCTimerAPI.domain.entities.StudySession;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class StudyTrackerPK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "matter_id")
	private Matter matter;
	
	@ManyToOne
	@JoinColumn(name = "session_id")
	private StudySession session;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Long sequence;
	
	public Matter getMatter() {
		return matter;
	}

	public void setMatter(Matter matter) {
		this.matter = matter;
	}

	public StudySession getSession() {
		return session;
	}

	public void setSession(StudySession session) {
		this.session = session;
	}
	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matter, sequence, session);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudyTrackerPK other = (StudyTrackerPK) obj;
		return Objects.equals(matter, other.matter) && Objects.equals(sequence, other.sequence)
				&& Objects.equals(session, other.session);
	}	
}
