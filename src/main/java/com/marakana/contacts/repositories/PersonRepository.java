package com.marakana.contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marakana.contacts.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
