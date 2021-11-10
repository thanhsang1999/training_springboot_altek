package com.example.managerstudent.utils.impl;

import com.example.managerstudent.expections.LocalDateExpection;
import com.example.managerstudent.utils.IDateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class DateValidatorLocalDateFormatter  implements IDateValidator {

    @Autowired
    @Qualifier("dateTimeFormatter")
    DateTimeFormatter dtf;

    @Override
    public boolean idValid(String dateStr) {
        try {
            LocalDate a = LocalDate.parse(dateStr,dtf);
        }catch (DateTimeParseException e){
            throw new LocalDateExpection("Data is not the same format");
        }
        return true;
    }
}
