package com.example.managerstudent.expections;

public class LocalDateExpection extends RuntimeException{
    public LocalDateExpection(String msg) {
        super(msg);
    }
}
