package com.cassol.service;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import com.cassol.repository.entity.Person;

@Service
public class EmailSender {
	
	public void sendEmails(List<Person> people) throws EmailException {
		
		for (Person person : people) {
			SimpleEmail email = new SimpleEmail();
			email.setHostName("localhost"); 
			email.setSmtpPort(2778);
			email.addTo(person.getEmail(), person.getName());
			email.setFrom("amigo@secreto.com", "Me"); 
			email.setSubject("Amigo secreto"); 
			email.setMsg("Seu amigo secreto é "+ person.getFriend().getName()); 
			email.send(); 
		}
	}

}
