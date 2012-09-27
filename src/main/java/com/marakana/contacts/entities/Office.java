package com.marakana.contacts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Office extends UrlEntity {

	@Column
	private String name;

	@OneToOne
	private Address address;

	@ManyToOne
	private Company company;

	public Office() {
	}

	public Office(Address address, Company company) {
		this.address = address;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
