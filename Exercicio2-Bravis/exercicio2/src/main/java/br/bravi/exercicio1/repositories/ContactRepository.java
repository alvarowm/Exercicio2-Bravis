package br.bravi.exercicio1.repositories;

import org.springframework.data.repository.CrudRepository;

import br.bravi.exercicio1.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	
}
