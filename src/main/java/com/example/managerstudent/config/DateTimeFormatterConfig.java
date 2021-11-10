package com.example.managerstudent.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeFormatterConfig {
    @Bean(name = "dateTimeFormatterVN")
    public DateTimeFormatter dateTimeFormatterVN(){
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }
    @Bean(name = "dateTimeFormatter")
    public DateTimeFormatter dateTimeFormatter(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

}
