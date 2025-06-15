package com.HBCTimerAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HBCTimerAPI.model.entities.DailyGoal;

public interface DailyGoalRepository extends JpaRepository<DailyGoal, Long> {

}
