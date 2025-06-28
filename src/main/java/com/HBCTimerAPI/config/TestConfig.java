package com.HBCTimerAPI.config;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.HBCTimerAPI.domain.entities.DailyGoal;
import com.HBCTimerAPI.domain.entities.Matter;
import com.HBCTimerAPI.domain.entities.StudySession;
import com.HBCTimerAPI.domain.entities.StudyTracker;
import com.HBCTimerAPI.domain.entities.User;
import com.HBCTimerAPI.repository.DailyGoalRepository;
import com.HBCTimerAPI.repository.MatterRepository;
import com.HBCTimerAPI.repository.StudySessionRepository;
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
	private StudySessionRepository sessionRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
	DailyGoal dg1 = new DailyGoal(null, Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2019-06-20T20:53:07Z"));
	
	dailyGoalRepository.save(dg1);
	
	User u1 = new User(null, "kaua", "kaua@gmail", "q1234");
	User u2 = new User(null, "Luana", "Luana@gmail", "4321q");
	
	userRepository.saveAll(Arrays.asList(u1, u2));
			
	Matter m1 = new Matter(null, "Portugues", "Segunda", u1);
	Matter m2 = new Matter(null, "Matematica", "Quarta", u2);
	Matter m3 = new Matter(null, "Ciencias", "Sexta", u2);
	
	
	matterRepository.saveAll(Arrays.asList(m1,m2,m3));
	
	StudySession ss1 = new StudySession(null, Instant.parse("2025-06-22T18:05:00Z"), Duration.ZERO, u1);
	
	
	StudyTracker st1 = new StudyTracker(m1, ss1, null, Instant.parse("2025-06-22T18:05:00Z"), Instant.parse("2025-06-22T19:05:00Z"), false);
	StudyTracker st2 = new StudyTracker(m1, ss1, null, Instant.parse("2025-06-22T19:05:00Z"), Instant.parse("2025-06-22T21:05:00Z"), false);

	ss1.addTracker(st1);
	ss1.addTracker(st2);
	
	
	sessionRepository.save(ss1);
	}
}
