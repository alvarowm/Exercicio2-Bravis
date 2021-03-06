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

import br.bravi.exercicio1.models.Contact;
import br.bravi.exercicio1.services.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService service;
	
	@RequestMapping("person/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable("id") Long id) {
        return new ResponseEntity<Contact>((Contact) service.findByID(id),HttpStatus.OK);
    }
	
	@PostMapping("/person/contact")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
		return new ResponseEntity<Contact>((Contact) service.save(contact),HttpStatus.CREATED);
    }
	
	@PutMapping("/person/contact/{id}")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact, @PathVariable("id") Long id) {
		return new ResponseEntity<Contact>((Contact) service.update(contact, id), HttpStatus.OK);
    }
	
	@DeleteMapping("/person/contact/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") Long id) {
		if (service.delete(id))
			return new ResponseEntity<String>("Contact with id: " + id + " was deleted!", HttpStatus.OK);
			
			return new ResponseEntity<String>("There was a problem, the Contact can not be excluded!", HttpStatus.OK);
    }

}
