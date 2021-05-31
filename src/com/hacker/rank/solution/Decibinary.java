package com.hacker.rank.solution;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Decibinary {
    /*public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long x = Long.parseLong(bufferedReader.readLine().trim());

                long result = decibinaryNumbers(x);
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }
    */
    public static long decibinaryNumbers(long x){
        long numberOfDigit=(long) Math.log10(x);
        
        System.out.println(numberOfDigit);
        for(int i=0;i<numberOfDigit;i++){
           // Math.pow(a, b);
        }
        
       
        return 0;
    }
    
    public static void main(String[] args) {
        decibinaryNumbers(2016);
    }
    
    
}
