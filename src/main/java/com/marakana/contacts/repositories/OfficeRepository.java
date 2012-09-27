package com.marakana.contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marakana.contacts.entities.Office;

public interface OfficeRepository extends JpaRepository<Office, Long> {
}
