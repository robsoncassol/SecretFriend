package com.cassol.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message="{person.name.empty}")
	@NotBlank(message="{person.name.empty}")
	private String name;
	
	@NotNull(message="{person.email.empty}")
	@Email(message="{person.email.invalid}")
	@NotBlank(message="{person.name.empty}")
	private String email;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

}
