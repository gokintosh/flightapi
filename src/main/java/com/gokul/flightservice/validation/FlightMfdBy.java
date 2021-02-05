package com.gokul.flightservice.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = FlightMfdByValidator.class)
public @interface FlightMfdBy {
    public String message() default "The manufacturer value is invalid";
    public Class<?>[]groups()default {};
    public Class<? extends Payload>[] payload() default {};
}
