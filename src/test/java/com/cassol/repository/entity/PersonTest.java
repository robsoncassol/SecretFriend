package com.cassol.repository.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PersonTest {

	@Test
	public void shouldRandomlyChooseOnePersonX1000() {
		int i = 0;
		while(i++<1000){
			shouldRandomlyChooseOnePerson();
		}
	}
	
	public void shouldRandomlyChooseOnePerson() {
		List<Person> people = new ArrayList<>();
		
		Person person1 = new Person(1L);
		Person person2 = new Person(2L);
		
		people.add(person1);
		people.add(person2);
		
		Person p = person1.chooseOne(people);
		
		assertFalse(people.contains(p));
	}
	
	
	@Test
	public void shouldRandomlyChooseOnePersonDifferentFromSelfX1000() {
		int i = 0;
		while(i++<1000){
			shouldRandomlyChooseOnePersonDifferentFromSelf();
		}
	}


	private void shouldRandomlyChooseOnePersonDifferentFromSelf() {
		List<Person> people = new ArrayList<>();
		Person person1 = new Person(1L);
		Person person2 = new Person(2L);
		
		people.add(person1);
		people.add(person2);
		
		Person p = person1.chooseOne(people);
		assertFalse(p.equals(person1));
		
		p = person2.chooseOne(people);
		assertFalse(p.equals(person2));
	}
	
	
	@Test(expected=IllegalStateException.class)
	public void shouldThrowExceptionWhenTheLastOneIsHimSelfX1000() {
		int i = 0;
		while(i++<1000){
			shouldThrowExceptionWhenTheLastOneIsHimSelf();
		}
	}


	private void shouldThrowExceptionWhenTheLastOneIsHimSelf() {
		List<Person> people = new ArrayList<>();
		Person person1 = new Person(1L);
		Person person2 = new Person(2L);
		Person person3 = new Person(3L);
		
		people.add(person1);
		people.add(person2);
		people.add(person3);
		
		Person p = person1.chooseOne(people);
		assertFalse(p.equals(person1));
		
		p = person2.chooseOne(people);
		assertFalse(p.equals(person2));

		p = person3.chooseOne(people);
		assertFalse(p.equals(person3));
	}
	
	
	
	
	private List<Person> buildPersonList(int numberOfElements){
		List<Person> people = new ArrayList<>();
		long i = 0L;
		while(i++<numberOfElements){
			Person person1 = new Person(i);
			people.add(person1);
		}
		return people;
	}

}
