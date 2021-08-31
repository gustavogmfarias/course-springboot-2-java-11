package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service
public class OrderService {
	/*
	 * Isso mesmo! Normalmente se utiliza uma camada de serviço no meio, entre o
	 * controller e o repository, na qual ficam as regras de negócio e chamada ao
	 * repository para persistir/recuperar os dados do banco.
	 */

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		
		return repository.findAll();
	} 
	
	
	public Order findById(Long id) {
		
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
	
	
}
