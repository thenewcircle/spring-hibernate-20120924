package com.marakana.contacts.repositories;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.marakana.contacts.entities.Address;

public class AddressRepository {

	private final DataSource ds;

	public AddressRepository() {
		try {
			Context context = new InitialContext();
			try {
				ds = (DataSource) context.lookup("java:comp/env/jdbc/trainingdb");
			} finally {
				context.close();
			}
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	public void init() {
		
	}

	public Address find(long id) {
		return null; // TODO
	}

	public void create(Address address) {
		
	}

	public void delete(Address address) {
		
	}
}
