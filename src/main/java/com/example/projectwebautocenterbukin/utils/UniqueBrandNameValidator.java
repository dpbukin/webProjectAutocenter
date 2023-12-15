package com.example.projectwebautocenterbukin.utils;


import com.example.projectwebautocenterbukin.repositories.BrandRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueBrandNameValidator implements ConstraintValidator<UniqueBrandName, String> {

    private final BrandRepository brandRepository;

    public UniqueBrandNameValidator(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return brandRepository.findByName(s).isEmpty();
    }
}
