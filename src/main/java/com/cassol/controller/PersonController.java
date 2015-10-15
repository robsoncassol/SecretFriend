package com.cassol.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cassol.repository.PersonRepository;
import com.cassol.repository.entity.Person;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@RequestMapping("list")
	public Iterable<Person> list() {
		Iterable<Person> persons = personRepository.findAll();
		return persons;
	}

	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Person add(final @RequestBody @Valid Person person, BindingResult result)
			throws MethodArgumentNotValidException, NoSuchMethodException, SecurityException {

		if (result.hasErrors()) {
			MethodParameter parameter = new MethodParameter(this.getClass().getMethod("add", Person.class, BindingResult.class), 0);
			throw new MethodArgumentNotValidException(parameter, result);
		} else {
			personRepository.save(person);
		}

		return person;
	}


	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		personRepository.delete(id);
	}
	
	

}
