package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{ // faz orderrepositoy se tornar una jpa, do tipo
	// order, retonando long

}
