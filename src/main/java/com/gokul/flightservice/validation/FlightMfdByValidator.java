package com.gokul.flightservice.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class FlightMfdByValidator implements ConstraintValidator<FlightMfdBy,String> {

    List<String> approvedMfd= Arrays.asList("BOEING","AIRBUS","CIAN","BHARATPLANE");
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value==null||value.isBlank())return false;
        if(approvedMfd.contains(value))
            return true;
        else
            return false;


    }
}
