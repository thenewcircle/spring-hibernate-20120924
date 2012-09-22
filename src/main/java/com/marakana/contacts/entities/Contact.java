package com.marakana.contacts.entities;

public class Contact {
	private Long id;
	private String name;
	private Long addressId;

	public Contact() {}

	public Contact(Long id, String name, Long addressId) {
		this.id = id;
		this.name = name;
		this.addressId = addressId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

}
