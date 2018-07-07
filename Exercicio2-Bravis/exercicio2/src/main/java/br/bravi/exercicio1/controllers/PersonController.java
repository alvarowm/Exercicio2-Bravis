package br.bravi.exercicio1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.bravi.exercicio1.models.Person;
import br.bravi.exercicio1.services.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;
	
	@RequestMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
        return new ResponseEntity<Person>((Person) service.findByID(id),HttpStatus.OK);
    }
	
	@PostMapping("/person")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
		return new ResponseEntity<Person>((Person) service.save(person),HttpStatus.CREATED);
    }
	
	@PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable("id") Long id) {
		return new ResponseEntity<Person>((Person) service.update(person, id),HttpStatus.OK);
    }
	
	@DeleteMapping("/person/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Long id) {
		if (service.delete(id))
		return new ResponseEntity<String>("Person with id: " + id + " was deleted!", HttpStatus.OK);
		
		return new ResponseEntity<String>("There was a problem, the Person can not be excluded!", HttpStatus.OK);
    }
	
	

}
