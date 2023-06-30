package com.crio.shorturl;

import java.util.Random;

public class RandomGenerator {
    private static final String[] alphaNumbers =  {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", 
                                            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                                            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
                                            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                                            "0", "9", "8", "7", "6", "5", "4", "3", "2", "1"};

                                        
    public static String generate(){

        Random rd = new Random();

        int min = 0, max = 62;
        
        return alphaNumbers[rd.nextInt(max - min) + min] +
               alphaNumbers[rd.nextInt(max - min) + min] +
               alphaNumbers[rd.nextInt(max - min) + min] +
               alphaNumbers[rd.nextInt(max - min) + min] +
               alphaNumbers[rd.nextInt(max - min) + min] +
               alphaNumbers[rd.nextInt(max - min) + min] +
               alphaNumbers[rd.nextInt(max - min) + min] +
               alphaNumbers[rd.nextInt(max - min) + min] +
               alphaNumbers[rd.nextInt(max - min) + min] ;
    }
}
