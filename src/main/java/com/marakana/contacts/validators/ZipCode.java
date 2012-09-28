package com.marakana.contacts.validators;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ZipCodeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ZipCode {
	String message() default "zip code must be five numeric characters";

	Class<?>[] groups() default {};

	Class<?>[] payload() default {};
}