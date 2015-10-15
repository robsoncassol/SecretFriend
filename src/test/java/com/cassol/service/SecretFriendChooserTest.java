package com.cassol.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cassol.repository.entity.Person;

public class SecretFriendChooserTest {

	private SecretFriendChooser secretFriendChooser;

	@Before
	public void setUp() {
		secretFriendChooser = new SecretFriendChooser();
	}

	@Test
	public void shouldValidadeEmptyList() {
		List<Person> people = new ArrayList<>();

		Boolean b = secretFriendChooser.validate(people);

		Assert.assertFalse(b);
	}

	@Test
	public void shouldValidadeListWithLessThan2Elements() {
		List<Person> people = new ArrayList<>();
		people.add(new Person());

		Boolean b = secretFriendChooser.validate(people);

		Assert.assertFalse(b);
	}

	@Test
	public void shouldValidadeListWithMoreThan1Elements() {
		List<Person> people = new ArrayList<>();
		people.add(new Person());
		people.add(new Person());

		Boolean b = secretFriendChooser.validate(people);

		Assert.assertTrue(b);
	}

	/**
	 * 
	 * Devido a natureza randomica do método, ele deve ser testado exaustivamente 
	 * 
	 */
	
	@Test
	public void shouldRaffleAListOf3PersonWhoCanNotBeThemSelvesX1000() {
		int i = 0;
		while (i++ < 1000) {
			List<Person> people = buildPersonList(3);
			secretFriendChooser.raffle(people);
			
			for (Person person : people) {
				Assert.assertFalse(person.getFriend().equals(person));
			}
			
		}
	}

	private List<Person> buildPersonList(int numberOfElements) {
		List<Person> people = new ArrayList<>();
		long i = 0L;
		while (i++ < numberOfElements) {
			Person person1 = new Person(i);
			people.add(person1);
		}
		return people;
	}

}
