package com.HBCTimerAPI.config;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.HBCTimerAPI.model.entities.DailyGoal;
import com.HBCTimerAPI.model.entities.Matter;
import com.HBCTimerAPI.model.entities.StudySession;
import com.HBCTimerAPI.model.entities.StudyTracker;
import com.HBCTimerAPI.model.entities.User;
import com.HBCTimerAPI.repository.DailyGoalRepository;
import com.HBCTimerAPI.repository.MatterRepository;
import com.HBCTimerAPI.repository.StudySessionRepository;
import com.HBCTimerAPI.repository.StudyTrackerRepository;
import com.HBCTimerAPI.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MatterRepository matterRepository;
	
	@Autowired
	private DailyGoalRepository dailyGoalRepository;
	
	@Autowired
	private StudyTrackerRepository studyTrackerRepository;
	
	@Autowired
	private StudySessionRepository sessionRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
	DailyGoal dg1 = new DailyGoal(null, Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2019-06-20T20:53:07Z"));
	
	dailyGoalRepository.save(dg1);
	
	User u1 = new User(null, "kaua", "kaua@gmail", "q1234");
	User u2 = new User(null, "Luana", "Luana@gmail", "4321q");
	
	userRepository.saveAll(Arrays.asList(u1, u2));
			
	Matter m1 = new Matter(null, "Portugues", "aulas", u1);
	
	matterRepository.save(m1);
	
	StudySession ss1 = new StudySession(null, Instant.parse("2025-06-22T18:05:00Z"), Duration.ZERO, u1);
	
	sessionRepository.save(ss1);
	
	StudyTracker st1 = new StudyTracker(m1, ss1, Instant.parse("2025-06-22T17:05:00Z") , Instant.parse("2025-06-22T18:05:00Z"), true);
	
	studyTrackerRepository.save(st1);
	
	StudySession ss2 = new StudySession(null, Instant.parse("2025-06-22T18:05:00Z"), st1.getTotalTime() , u1);
	
	sessionRepository.save(ss2);
	
	}
}
