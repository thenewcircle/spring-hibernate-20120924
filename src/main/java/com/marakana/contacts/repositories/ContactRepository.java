package com.marakana.contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marakana.contacts.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
