package com.cassol.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cassol.model.Person;

@Repository
public class PersonHibernateRepository implements PersonRepository{

	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public void delete(Long id) {
		
	}

	@Override
	public void delete(Person person) {
		
	}

	@Override
	@Transactional
	public List<Person> findAll() {
		return entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
	}

	@Override
	@Transactional
	public Person persist(Person person) {
		entityManager.persist(person);
		return person;
	}


	@Override
	public Person findByName(String name) {
		TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p WHERE p.name = :name", Person.class);
		query.setParameter(":name", name);
		return query.getSingleResult();
	}

	@Override
	public Person findByEmail(String email) {
		TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p WHERE p.email = :email", Person.class);
		query.setParameter(":email", email);
		return query.getSingleResult();
	}

}
