package com.example.projectwebautocenterbukin.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;

@Component
public class ValidationUtilImpl implements ValidationUtil{
    private final Validator validator;

    @Autowired
    public ValidationUtilImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public <E> boolean isValid(E object) {
        Set<ConstraintViolation<E>> violations = this.validator.validate(object);
        return violations.size() == 0 && !containsSpecialCharacters(object);
    }

    @Override
    public <E> Set<ConstraintViolation<E>> violations(E object) {
        return this.validator.validate(object);
    }

    private <E> boolean containsSpecialCharacters(E object) {
        if (object instanceof String) {
            String str = (String) object;
            return str.matches(".*[^a-zA-Z0-9а-яА-Я].*");
        }
        return false;
    }
}
