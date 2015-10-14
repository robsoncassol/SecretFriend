package com.cassol.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cassol.model.Person;
import com.cassol.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping("list")
	public List<Person> list(Model model) {
		List<Person> persons = personRepository.findAll();
		return persons;
	}

	@RequestMapping("form")
	public String form() {
		return "person/form";
	}

	@RequestMapping("add")
	public Person add(@Valid Person person, BindingResult result) throws MethodArgumentNotValidException, NoSuchMethodException, SecurityException {
		
		if (result.hasErrors() ) {
			MethodParameter parameter = new MethodParameter(this.getClass().getMethod("add", Person.class, BindingResult.class), 0);
			throw new MethodArgumentNotValidException(parameter, result);
		}else{
			personRepository.persist(person);
		}
		
		return person;
	}

	@RequestMapping("edit")
	public String edit() {
		return "person/edit";
	}

	@RequestMapping("delete")
	public String delete() {
		return "person/delete";
	}


}
