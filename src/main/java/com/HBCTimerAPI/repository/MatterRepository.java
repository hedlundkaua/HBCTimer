package com.HBCTimerAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HBCTimerAPI.model.entities.Matter;

public interface MatterRepository extends JpaRepository<Matter, Long>{

}
