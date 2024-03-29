package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	/*
	 * Isso mesmo! Normalmente se utiliza uma camada de serviço no meio, entre o
	 * controller e o repository, na qual ficam as regras de negócio e chamada ao
	 * repository para persistir/recuperar os dados do banco.
	 */

	public List<User> findAll(){
		
		return repository.findAll();
	} 
	
	
	public User findById(Long id) {
		
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	
	
}
