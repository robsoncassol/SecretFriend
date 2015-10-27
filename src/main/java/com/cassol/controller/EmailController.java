package com.cassol.controller;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cassol.repository.PersonRepository;
import com.cassol.repository.entity.Person;
import com.cassol.service.EmailSender;

@RestController
public class EmailController {
	
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private EmailSender sender;

	@RequestMapping(value = "/send/emails", method = RequestMethod.POST)
	public ResponseEntity<Void> sendEmails() {
		try {
			
			List<Person> persons = personRepository.findAll();
			sender.sendEmails(persons);
			
		} catch (EmailException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
