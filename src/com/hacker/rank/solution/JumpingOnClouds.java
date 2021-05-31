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

public class JumpingOnClouds {

    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = jumpingOnClouds(c);
        System.out.println(result);
      

        bufferedReader.close();
      
    }
    
    public static int jumpingOnClouds( List<Integer> c){
        int stepsTaken=0;
        int n=c.size();
        for(int i=0;i<n;){
            int nexttoNextIndices=i+2<n-1?i+2:n-1 ;
          
            if(c.get(nexttoNextIndices)==0){
                stepsTaken++;
                i=nexttoNextIndices;
            }else  {
                stepsTaken++;
                i++;
            }
            if(i>=n-1){
                break;
            }
        }
        return stepsTaken;
    }
}
