package com.cassol.service;

import java.util.List;

import com.cassol.repository.entity.Person;

public class RandomPersonSelector {

	public Boolean validate(List<Person> people) {
		return people != null && people.size() > 1;
	}
	
	
	
	

}
