package com.HBCTimerAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HBCTimerAPI.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
