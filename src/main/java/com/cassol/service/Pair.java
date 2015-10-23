package com.cassol.service;

import com.cassol.repository.entity.Person;

public class Pair {

	private Person person;
	private Person friend;

	public Pair(Person person, Person friend) {
		this.setPerson(person);
		this.setFriend(friend);
	}

	public Person getFriend() {
		return friend;
	}

	public void setFriend(Person friend) {
		this.friend = friend;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
