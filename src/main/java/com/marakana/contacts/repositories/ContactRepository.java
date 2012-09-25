package com.marakana.contacts.repositories;

import com.marakana.contacts.entities.Contact;

public class ContactRepository extends Repository<Contact> {
	public ContactRepository() {
		super(Contact.class);
	}
}
