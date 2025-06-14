package com.HBCTimerAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HBCTimerAPI.model.entities.User;
import com.HBCTimerAPI.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository; //usado para resolver injeção de dependência e associar uma instância de UserRepository.
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); //Optional Usado quando podemos ter ou não uma resposta
		return obj.get();
	}
	
	public User insert(User obj){
		return repository.save(obj);
	}
	
}
