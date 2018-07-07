package br.bravi.exercicio1.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
@NamedEntityGraph(name = "joined", includeAllAttributes = true)
public class Person {
	
	@Id
	@GeneratedValue
	@Column(name = "person_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "person_id")
	private List<Contact> contatcs = new ArrayList<Contact>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contact> getContatcs() {
		return contatcs;
	}

	public void setContatcs(List<Contact> contatcs) {
		this.contatcs = contatcs;
	}

	public Person(String name, List<Contact> contatcs) {
		super();
		this.name = name;
		this.contatcs = contatcs;
	}

	public Person() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
