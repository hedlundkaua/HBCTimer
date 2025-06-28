package com.HBCTimerAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HBCTimerAPI.domain.entities.Matter;
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

	public Matter insert(Matter matter) {
		return repository.save(matter);
	}
	
	public Matter update(Long id, Matter obj) {
		Matter matter = repository.getReferenceById(id);
		updateData(matter, obj);
		return repository.save(matter);
	}
	
	private void updateData(Matter matter, Matter obj) {
		matter.setName(obj.getName());
		matter.setDescription(obj.getDescription());		
	}
	
}
