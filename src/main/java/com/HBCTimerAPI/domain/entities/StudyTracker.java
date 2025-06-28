package com.HBCTimerAPI.domain.entities;

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

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 */	
	
	@EmbeddedId
    private StudyTrackerPK id = new StudyTrackerPK();
	
	private Instant startTime;
	private Instant endTime;
	private Boolean isActive;	
	
	/*@ManyToOne
	@JoinColumn(name = "matter_id")
	private Matter matter;
	
	@ManyToOne
	@JoinColumn(name = "session_id")
	private StudySession session;
	
	public StudyTracker() {
		
	}
	
	public StudyTracker(Long id, Instant startTime, Instant endTime, Boolean isActive, Matter matter,
			StudySession session) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isActive = isActive;
		this.matter = matter;
		this.session = session;
	}

	public Long getId() {
		return id;
	}
	
	*/
	
	public StudyTracker() {
		
	}
	
	public StudyTracker(Matter matter, StudySession session, Long sequence, Instant startTime, Instant endTime, Boolean isActive) {
		super();
		id.setMatter(matter);
		id.setSession(session);
		this.startTime = startTime;
		this.endTime = endTime;
		this.isActive = isActive;
		id.setSequence(sequence);
	}
	
	@JsonIgnore
	public Matter getMatter() {
		return id.getMatter();
	}
	
	@JsonIgnore
	public StudySession getSession() {
		return id.getSession();
	}
	
	
	public Instant getStartTime() {
		return startTime;
	}
	public void setSession(StudySession session) {
		id.setSession(session);
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
	    }else {
	    	
	    }
	    return Duration.ZERO;
	}
	
	public void updateSessionTotalTime() {
	    if (getSession() != null) {
	        Duration total = getSession().getItems().stream()
	            .map(StudyTracker::getTotalTime)
	            .reduce(Duration.ZERO, Duration::plus);

	        getSession().setTotalTimeOfDay(total);
	    }
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
