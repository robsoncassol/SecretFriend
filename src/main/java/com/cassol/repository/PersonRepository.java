package com.cassol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassol.repository.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	Person findByEmail(String email);
    
}