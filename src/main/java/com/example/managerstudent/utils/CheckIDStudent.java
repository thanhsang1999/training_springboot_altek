package com.example.managerstudent.utils;

import com.example.managerstudent.expections.IDStudentExpection;

public class CheckIDStudent {
    public static boolean check(int mssv){
        if (mssv<10){
            throw new IDStudentExpection("id student more than 10");
        }else {
            return true;
        }

    }
}
