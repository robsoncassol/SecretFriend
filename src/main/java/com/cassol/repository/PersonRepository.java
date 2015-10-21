package com.cassol.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cassol.repository.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
    Page<Person> findByNameIgnoreCaseOrEmailIgnoreCase(String name, String email, Pageable pageable);
    Long countByNameIgnoreCaseOrEmailIgnoreCase(String name, String email);
	Person findByEmail(String email);
    
}