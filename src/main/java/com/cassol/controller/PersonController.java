package com.cassol.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cassol.repository.PersonRepository;
import com.cassol.repository.entity.Person;

@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;


	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> listAll() {
		List<Person> persons = personRepository.findAll();
		if (persons.isEmpty()) {
			return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}


	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> getPerson(@PathVariable("id") long id) {
		Person person = personRepository.findOne(id);
		if (person == null) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public ResponseEntity<Void> createPerson(@RequestBody @Valid Person person, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED);
		}

		if (personRepository.findByEmail(person.getEmail())!=null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		personRepository.save(person);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
    
    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
        Person currentPerson = personRepository.findOne(id);
         
        if (currentPerson==null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
 
        currentPerson.setName(person.getName());
        currentPerson.setEmail(person.getEmail());
        
        personRepository.save(currentPerson);
        return new ResponseEntity<Person>(currentPerson, HttpStatus.OK);
    }


    
    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> deletePerson(@PathVariable("id") long id) {
 
        Person person = personRepository.findOne(id);
        if (person == null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
 
        personRepository.delete(id);
        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
    }
    

}
