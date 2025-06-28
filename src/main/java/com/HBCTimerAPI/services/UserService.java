package com.HBCTimerAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HBCTimerAPI.model.entities.User;
import com.HBCTimerAPI.repository.UserRepository;
import com.HBCTimerAPI.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository; //usado para resolver injeção de dependência e associar uma instância de UserRepository.
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); //Optional Usado quando podemos ter ou não uma resposta
		return obj.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado!"));
		
	}
	
	public User insert(User obj){
		return repository.save(obj);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User user = repository.getReferenceById(id);
		updateData(user, obj);
		return repository.save(user);
	}
	
	public void updateData(User user, User obj) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
	}
	
}
