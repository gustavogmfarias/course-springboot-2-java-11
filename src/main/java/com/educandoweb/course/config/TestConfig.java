package com.educandoweb.course.config;

import java.time.Instant; 
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration//informa que é uma config
@Profile("test")//informa que é pra usar o modo teste
public class TestConfig implements CommandLineRunner { // nesse teste tem que implementar a command line runner para ela
														// executar com a inicialização

	@Autowired //serve para injetar dependência automaticamente no userrepository
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		userRepository.saveAll(Arrays.asList(u1, u2)); // sempre se salva como uma lista

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); //hora no formato sei lá o que kkk
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}

}
