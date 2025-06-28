package com.HBCTimerAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void deleteById(Long id) {
		repository.deleteById(id);	
	}

}
