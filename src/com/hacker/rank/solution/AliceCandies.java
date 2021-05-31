package com.hacker.rank.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AliceCandies {
    /*
     * Complete the 'candies' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static long candies(int n, List<Integer> arr) {
    // Write your code here
        long result=0;
       
        int [] candiesDestribution= new int[n];
        Arrays.fill(candiesDestribution, 1);
        for(int i=1;i<n;i++){
            if(arr.get(i)>arr.get(i-1)){
                candiesDestribution[i]=candiesDestribution[i-1]+1;
            }
        } 
        
        for(int i=n-1;i>=1;i--){
            if(arr.get(i)<arr.get(i-1)){
                candiesDestribution[i-1]=candiesDestribution[i-1]>candiesDestribution[i]?candiesDestribution[i-1]:candiesDestribution[i]+1;
            }
        }
        
        for (int i : candiesDestribution) {
           
            result=result+i;
        }
       
        return result;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        long result=candies(n, arr);
        System.out.println(result);

    }
}
