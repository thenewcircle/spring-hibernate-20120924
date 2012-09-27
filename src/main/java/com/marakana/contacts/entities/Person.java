package com.marakana.contacts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.marakana.contacts.validators.Employee;

@Entity
@Employee
public class Person extends Contact {

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private Address address;

	@ManyToOne
	private Person manager;

	@ManyToOne
	private Company employer;

	public Person() {
	}

	public Person(String name, Address address) {
		super(name);
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	public Company getEmployer() {
		return employer;
	}

	public void setEmployer(Company employer) {
		this.employer = employer;
	}

}
