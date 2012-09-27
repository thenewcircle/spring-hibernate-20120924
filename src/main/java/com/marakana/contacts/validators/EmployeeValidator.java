package com.marakana.contacts.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.marakana.contacts.entities.Company;
import com.marakana.contacts.entities.Person;

public class EmployeeValidator implements ConstraintValidator<Employee, Person> {

	@Override
	public void initialize(Employee employee) {
	}

	@Override
	public boolean isValid(Person person, ConstraintValidatorContext context) {
		Company employer = person.getEmployer();
		Person manager = person.getManager();
		return (employer == null || manager == null || employer.equals(manager.getEmployer()));
	}
}