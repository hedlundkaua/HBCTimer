package com.HBCTimerAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HBCTimerAPI.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
