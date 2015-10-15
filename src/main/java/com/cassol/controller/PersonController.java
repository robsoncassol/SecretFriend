package com.cassol.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Person> list(@RequestParam Integer page, @RequestParam Integer maxItensPage) {
		Page<Person> pagedList = personRepository.findAll(new PageRequest(page, maxItensPage));
		return pagedList.getContent();
	}

	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Person add(final @RequestBody @Valid Person person, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new MethodArgumentNotValidException(getMethodParamenter("add"), result);
		} else {
			personRepository.save(person);
		}

		return person;
	}


	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public Person edit(final @RequestBody @Valid Person person, BindingResult result) throws Exception {
		
		if(person.getId()==null){
			result.addError(new ObjectError("id", "person.edit.id.required"));
		}
		
		if (result.hasErrors()) {
			throw new MethodArgumentNotValidException(getMethodParamenter("edit"), result);
		} else {
			personRepository.save(person);
		}

		return person;
	}
	
	private MethodParameter getMethodParamenter(String methodName) throws NoSuchMethodException {
		MethodParameter parameter = new MethodParameter(this.getClass().getMethod(methodName, Person.class, BindingResult.class), 0);
		return parameter;
	}	


	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		personRepository.delete(id);
	}
	
	
	@RequestMapping(value = "search")
	public List<Person> search(@PathVariable String q, @RequestParam Integer page, @RequestParam Integer maxItensPage){
		Page<Person> pagedList = personRepository.findByNameIgnoreCaseOrEmailIgnoreCase(q, q, new PageRequest(page, maxItensPage));
		return pagedList.getContent();
	}
	

}
