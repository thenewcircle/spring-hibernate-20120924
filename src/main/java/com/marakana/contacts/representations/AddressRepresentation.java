package com.marakana.contacts.representations;

import com.marakana.contacts.entities.Address;

public class AddressRepresentation {

	public final String street;
	public final String city;
	public final String state;
	public final String zip;

	public AddressRepresentation(Address address) {
		this.street = address.getStreet();
		this.city = address.getCity();
		this.state = address.getState();
		this.zip = address.getZip();
	}

}
