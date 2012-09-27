package com.marakana.contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marakana.contacts.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
