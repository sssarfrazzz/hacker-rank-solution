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

public class MarkAndToys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = maximumToys(prices, k);

        System.out.println(result);
        bufferedReader.close();
    }
    
    public static int maximumToys(List<Integer> prices,int k){
        Collections.sort(prices);
        int sum=0;
        if(prices.get(0)>k){
            return 0;
        }
        for(int i=0;i<k;i++){
            
            
            if(sum+prices.get(i)>k)
                return i;
            else {
                sum=sum+prices.get(i);
            }
        }
        return k;
    }
}
