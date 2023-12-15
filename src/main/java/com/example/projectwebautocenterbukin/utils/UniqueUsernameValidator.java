package com.example.projectwebautocenterbukin.utils;


import com.example.projectwebautocenterbukin.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.findByUsername(s).isEmpty();
    }
}
