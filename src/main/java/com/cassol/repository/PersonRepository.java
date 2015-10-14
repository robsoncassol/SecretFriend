package com.cassol.repository;

import java.util.List;

import com.cassol.model.Person;

public interface PersonRepository {

	public void delete(Long id);

	public void delete(Person person);

	public List<Person> findAll();

	public Person persist(Person person);

	public Person findByName(String name);

	public Person findByEmail(String email);
}