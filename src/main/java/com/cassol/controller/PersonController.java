package com.cassol.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cassol.model.Person;
import com.cassol.repository.PersonRepository;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping("list")
	public String list(Model model) {
		Iterable<Person> persons = personRepository.findAll();
		model.addAttribute("persons",persons);
		return "person/list";
	}

	@RequestMapping("form")
	public String form() {
		return "person/form";
	}

	@RequestMapping("add")
	public String add(@Valid Person person, BindingResult result) {

		if (result.hasFieldErrors("name") || result.hasFieldErrors("email") ) {
			return "person/form";
		}
		
		personRepository.persist(person);
		
		return "person/added";
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
