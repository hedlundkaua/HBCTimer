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
import com.HBCTimerAPI.model.entities.StudyTracker;
import com.HBCTimerAPI.model.entities.User;
import com.HBCTimerAPI.repository.DailyGoalRepository;
import com.HBCTimerAPI.repository.MatterRepository;
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
	
	@Override
	public void run(String... args) throws Exception {
	
	Matter m1 = new Matter(null, "Portugues", "aulas");
	
	matterRepository.save(m1);
		
	
	DailyGoal dg1 = new DailyGoal(null, Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2019-06-20T20:53:07Z"));
	
	dailyGoalRepository.save(dg1);
	
	User u1 = new User(null, "kaua", "kaua@gmail", "q1234");
	User u2 = new User(null, "Luana", "Luana@gmail", "4321q");
	
	userRepository.saveAll(Arrays.asList(u1, u2));
			
	StudyTracker st1 = new StudyTracker(null, Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2019-06-20T20:53:07Z"), Duration.ofHours(1).plusMinutes(30), false);
	
	studyTrackerRepository.save(st1);
		
	}
}
