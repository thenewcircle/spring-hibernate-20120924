package com.marakana.contacts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Office extends BaseEntity {

	@Column
	private String name;

	@ManyToOne(cascade=CascadeType.ALL)
	private Company company;

	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

	public Office() {}

	public Office(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		if (this.company != null)
			this.company.getOffices().remove(this);
		this.company = company;
		this.company.getOffices().add(this);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
