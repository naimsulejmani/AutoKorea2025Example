package dev.naimsulejmani.autokorea2025example.infrastructure.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD}) // ku me perdore, variable, parameter, klase, metode, kontruktore
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WithinYearsValidator.class)//kush e implement
@Documented
public @interface WithinYears {
    String message() default "Year must be within the last {maxYears} years";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int maxYears() default 10;
}










