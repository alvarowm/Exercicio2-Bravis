package br.bravi.exercicio1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.bravi.exercicio1.models.Contact;
import br.bravi.exercicio1.models.Person;
import br.bravi.exercicio1.repositories.ContactRepository;
import br.bravi.exercicio1.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Transactional
	public Person findByID(Long id) {
		Person p = personRepository.findOne(id);
		return p;
	}

	@Transactional
	public Person save(Person p) {
		return personRepository.save(p);
	}

	@Transactional
	public Person update(Person person, Long id) {
		Person p = personRepository.findOne(id);
		if (p == null)
			return null;

		p.setName(person.getName());

		if (person.getContatcs() != null) {
			for (Contact contact : person.getContatcs()) {
				if (contact.getId() == null) {
					p.getContatcs().add(contact);
				} else {
					Contact contatoAAtualizar = contactRepository.findOne(contact.getId());
					contatoAAtualizar.setContact(contact.getContact());
					contatoAAtualizar.setContactType(contact.getContactType());
				}
			}
		}

		return personRepository.save(p);
	}

	@Transactional
	public boolean delete(Long id) {
		if (id == null || !personRepository.exists(id))
			return false;
		
		try {
			personRepository.delete(id);
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
