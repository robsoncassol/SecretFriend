package com.cassol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cassol.repository.PersonRepository;
import com.cassol.repository.entity.Person;
import com.cassol.service.SecretFriendChooser;

@RestController
public class ShuffleController {

	@Autowired
	private PersonRepository personRepository;


	@RequestMapping(value = "/shuffle", method = RequestMethod.GET)
	public ResponseEntity<List<String>> shuffle(SecretFriendChooser secretFriendChooser) {
		List<Person> people = personRepository.findAll();
		
		List<String> Strings = secretFriendChooser.build(people);
		
		if (people.isEmpty()) {
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<String>>(Strings, HttpStatus.OK);
	}

}
