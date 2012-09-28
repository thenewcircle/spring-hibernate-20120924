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
		if (employer == null) {
			return manager == null;
		}

		while (manager != null) {
			if (person.equals(manager) || !employer.equals(manager.getEmployer()))
				return false;
			manager = manager.getManager();
		}
		return true;
	}

}