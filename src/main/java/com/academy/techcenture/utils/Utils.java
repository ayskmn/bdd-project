package com.academy.techcenture.utils;

public class Utils {
    public static int generateRandomNumber(int min, int max){
        int random=(int)(Math.random()*((max-min)+1)+min);
        return random;
    }
}
