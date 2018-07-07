package br.bravi.exercicio1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class Contact {
	
	@Id
	@GeneratedValue
	@Column(name = "contact_id")
	private Long id;

	@Column(name="type")
	private String contactType;
	
	@Column(name="contact")
	private String contact;

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Contact(String contactType, String contact) {
		super();
		this.contactType = contactType;
		this.contact = contact;
	}

	public Contact() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
}
