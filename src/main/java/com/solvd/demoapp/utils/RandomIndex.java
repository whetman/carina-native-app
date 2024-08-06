package com.solvd.demoapp.utils;

import java.util.Random;

public class RandomIndex {
    public static int randomize(int number){
        Random rand = new Random();
        return rand.nextInt(number);
    }
}
