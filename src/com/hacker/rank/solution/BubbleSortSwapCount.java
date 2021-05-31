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

public class BubbleSortSwapCount {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        countSwaps(a);

        bufferedReader.close();
    }
    
    public static void countSwaps(List<Integer> a) {
        // Write your code here
        int swapCount=0;
        Map<Integer, Integer>map=new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            int nUmberOfSwps=0;
            for (int j = 0; j < a.size() - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                
                if (a.get(j) > a.get(j + 1)) {
                    nUmberOfSwps++;
                    int temp=a.get(j);
                    a.set(j, a.get((j+1)));
                    a.set(j+1, temp);
                  
                }
            }
            
            if(nUmberOfSwps==0){
                break;
            } 
            swapCount=swapCount+nUmberOfSwps;
            
        }
        
        System.out.println("Array is sorted in"+ swapCount +" swaps.");
        System.out.println("First Element: "+a.get(0));
        System.out.println("Last Element: "+a.get(a.size()-1));
        }
}
