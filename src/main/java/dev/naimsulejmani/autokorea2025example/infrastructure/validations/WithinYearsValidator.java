package dev.naimsulejmani.autokorea2025example.infrastructure.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class WithinYearsValidator implements ConstraintValidator<WithinYears, Integer> {
    private int maxYears;

    //per me mujt me marr konfigurimet e annotations
    @Override
    public void initialize(WithinYears constraintAnnotation) {
        this.maxYears = constraintAnnotation.maxYears();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        int currentYear = LocalDateTime.now().getYear();
        int minYear = currentYear - maxYears;
        return integer >= minYear;
    }
}
