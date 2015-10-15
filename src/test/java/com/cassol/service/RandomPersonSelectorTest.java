package com.cassol.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.cassol.repository.entity.Person;

public class RandomPersonSelectorTest {

	@Test
	public void shouldValidadeEmptyList() {
		List<Person> people = new ArrayList<>();
		
		Boolean b = new RandomPersonSelector().validate(people);
		
		Assert.assertFalse(b);
	}

	@Test
	public void shouldValidadeListWithLessThan2Elements() {
		List<Person> people = new ArrayList<>();
		people.add(new Person());
		
		Boolean b = new RandomPersonSelector().validate(people);
		
		Assert.assertFalse(b);
	}
	
	@Test
	public void shouldValidadeListWithMoreThan1Elements() {
		List<Person> people = new ArrayList<>();
		people.add(new Person());
		people.add(new Person());
		
		Boolean b = new RandomPersonSelector().validate(people);
		
		Assert.assertTrue(b);
	}
	
	
	

}
