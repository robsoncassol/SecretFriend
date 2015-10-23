package com.cassol.service;

import java.util.ArrayList;
import java.util.List;

import com.cassol.exceptions.PersonLeftAreTheSameException;
import com.cassol.repository.entity.Person;

public class SecretFriendChooser {

	Boolean validate(List<Person> people) {
		return people != null && people.size() > 1;
	}
	
	public List<Pair> build(List<Person> people){
		raffle(people);
		
		List<Pair> pairs = new ArrayList<>();

		for (Person person : people) {
			pairs.add(new Pair(person,person.getFriend()));
		}
		
		return pairs;
	}

	void raffle(List<Person> people) {
		if (validate(people)) {
			try {

				List<Person> potNames = new ArrayList<>(people);
				int i = 0;
				while (potNames.size() > 0) {
					people.get(i).chooseOne(potNames);
					i++;
				}

			} catch (PersonLeftAreTheSameException e) {
				raffle(people); // Quando a ultima pessoal pega ela mesma, é
								// necessário reiniciar o processo.
			}

		}
	}
	

}
