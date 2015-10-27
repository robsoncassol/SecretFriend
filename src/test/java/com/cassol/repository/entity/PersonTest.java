package com.cassol.repository.entity;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.cassol.exceptions.PersonLeftAreTheSameException;



/**
 * 
 * Devido a natureza randomica de alguns métodos, foram feitos testes estatístico.  
 * 
 */

public class PersonTest {
	
	
	@Test
	public void shouldShowRelationship(){
		Person person1 = new Person(1L,"Robson");
		Person person2 = new Person(2L,"Priscila");
		person1.setFriend(person2);
		
		Assert.assertEquals("Robson saiu com Priscila", person1.relationship());
	}

	@Test
	public void shouldRandomlyChooseOnePersonX1000() throws PersonLeftAreTheSameException {
		int i = 0;
		while(i++<1000){
			shouldRandomlyChooseOnePerson();
		}
	}
	
	public void shouldRandomlyChooseOnePerson() throws PersonLeftAreTheSameException {
		List<Person> people = new ArrayList<>();
		
		Person person1 = new Person(1L);
		Person person2 = new Person(2L);
		
		people.add(person1);
		people.add(person2);
		
		Person p = person1.chooseOne(people);
		
		assertFalse(people.contains(p));
	}
	
	
	@Test
	public void shouldRandomlyChooseOnePersonDifferentFromSelfX1000() throws PersonLeftAreTheSameException {
		int i = 0;
		while(i++<1000){
			shouldRandomlyChooseOnePersonDifferentFromSelf();
		}
	}


	private void shouldRandomlyChooseOnePersonDifferentFromSelf() throws PersonLeftAreTheSameException {
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
	
	
	@Test(expected=PersonLeftAreTheSameException.class)
	public void shouldThrowExceptionWhenTheLastOneIsHimSelfX1000() throws PersonLeftAreTheSameException {
		int i = 0;
		while(i++<1000){
			shouldThrowExceptionWhenTheLastOneIsHimSelf();
		}
	}


	
	private void shouldThrowExceptionWhenTheLastOneIsHimSelf() throws PersonLeftAreTheSameException {
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
	
	
	
	
	

}
