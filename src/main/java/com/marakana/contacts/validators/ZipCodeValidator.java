package com.marakana.contacts.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

	@Override
	public void initialize(ZipCode zipCode) {
	}

	@Override
	public boolean isValid(String string, ConstraintValidatorContext context) {
		if (string.length() != 5)
			return false;
		for (char c : string.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

}