package com.HBCTimerAPI.model.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.HBCTimerAPI.model.entities.Matter;
import com.HBCTimerAPI.model.entities.StudySession;

import jakarta.persistence.Embeddable;
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
	
	 private Integer sequence;
	
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
	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
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
