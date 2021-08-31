package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> { // faz orderrepositoy se tornar una jpa, do tipo
																		// order, retonando long
	/*
	 * Um repositório está vinculado à regra de negócio da aplicação e está
	 * associado ao agregado dos seus objetos de negócio e retorna objetos de
	 * domínio que representam esses dados.
	 * 
	 * Já o DAO (Data Access Object) a principio tem o seu escopo limitado na
	 * captura e persistência dos dados de um objeto DTO (Data Transfer Object) que
	 * representa um registro da base de dados, consequentemente ele transmite
	 * apenas o mundo físico relacional da base de dados e não representa o
	 * mini-mundo real do negócio da sua aplicação.
	 * 
	 * Repository: Avaliacao é regra de negócio, engloba tudo sobre essa regra,
	 * retornando objetos de domínio do negócio
	 */
}
