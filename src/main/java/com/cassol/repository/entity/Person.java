package com.cassol.repository.entity; 

import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.cassol.exceptions.PersonLeftAreTheSameException;
import com.fasterxml.jackson.annotation.JsonIgnore;



//@RepositoryRestResource(path = "people")
//interface PeopleRepository extends CrudRepository<Person, Long> {}

@Entity
public class Person {
	

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	@Email
	@NotBlank
	private String email;

	@JsonIgnore
	@ManyToOne
	private Person friend;

	
	public Person() {
	}
	
	public Person(Long id) {
		this.id = id;
	}

	public Person(Long id, String name) {
		this(id);
		this.name = name;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Person chooseOne(List<Person> people) throws PersonLeftAreTheSameException {
		Random random = new Random();
		
		int randomIndex = random.nextInt(people.size());
		
		if(people.get(randomIndex).equals(this)){
		
			if(people.size()>1)
				return chooseOne(people); //devolve o papel para o pote e tenta outro
			else
				throw new PersonLeftAreTheSameException("just left the same person");
			
		}
		
		setFriend(people.remove(randomIndex));
		
		return getFriend();
	}
	
	public String relationship(){
		if(getFriend()==null){
			
			throw new IllegalStateException("the names have not yet been drawn");
			
		}
		
		return this.getName() + " saiu com " + getFriend().getName();
	}

	public Person getFriend() {
		return friend;
	}

	public void setFriend(Person friend) {
		this.friend = friend;
	}
	
	
	
	
	

}
