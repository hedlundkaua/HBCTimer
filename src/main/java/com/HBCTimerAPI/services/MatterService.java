package com.HBCTimerAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.HBCTimerAPI.model.entities.Matter;
import com.HBCTimerAPI.repository.MatterRepository;

@Service
public class MatterService {

	@Autowired
	private MatterRepository repository;
	
	public List<Matter> findAll(){
		return repository.findAll();	
	}
	
	public Matter findById(Long id) {
		Optional<Matter> obj = repository.findById(id);
		return obj.get();
	}
	
}
