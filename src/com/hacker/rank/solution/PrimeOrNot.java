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

public class PrimeOrNot {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        int result = isPrime(n);

        System.out.println(result);
        bufferedReader.close();
    }

    public static int isPrime(long n) {
        // Write your code here
        int result = 1;
        if(n==2){
            result=1;
        }
        if (n % 2 == 0) {
            result = 2;
        }
        
        for(int i=3;i<n/2;i++){
            if(n%i==0){
                result=i;
                break;
            }
        }
        return result;
    }
}
