package com.marakana.contacts.representations;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.marakana.contacts.entities.Person;

public class PersonRepresentation {

	public final String name;
	public final AddressRepresentation address;
	public final Map<String, URI> links = new HashMap<String, URI>();

	public PersonRepresentation(Person person) {
		this.name = person.getName();
		this.address = new AddressRepresentation(person.getAddress());
		try {
			links.put("self", new URI("/person/" + person.getId()));
			links.put("collection", new URI("/contacts"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
