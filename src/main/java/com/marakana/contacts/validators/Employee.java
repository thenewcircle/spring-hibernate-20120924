package com.marakana.contacts.validators;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmployeeValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Employee {
    String message() default "manager and employee must work for the same company, management chain must be acyclic";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}