package com.hacker.rank.solution;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SherloclAnagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = isAnagram(s);
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
    
    public static int sherlockAndAnagrams(String s){
        int result=0;
        Map<String, String>anagramStore=new HashMap<String, String>();
        //How many duplicate characters
        for(int i=0;i<=s.length()/2;i++){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    anagramStore.put(s.substring(i,i+1), i+" "+j);
                    int k=j-i;
                    int l=i-k<0?0:i-k;
                    int n=0;
                    int m=0;
                    while(k<j){
                    }
                }
            }
        }
        System.out.println(anagramStore);
        return result;
    }
    
    public static int isAnagram(String s){
        HashMap<String, Integer> map = new HashMap<String, Integer>();

       
        int totalCount = 0;

        // Generate all substrings (N^2)
        for(int i = 0 ; i < s.length(); i++)
        {
            for(int j=i+1 ; j <= s.length(); j++)
            {
                String currentSubString = s.substring(i,j);

                // Sort all strings E.g. ab & ba both == ab now
                char[] chars = currentSubString.toCharArray();
                Arrays.sort(chars);
                currentSubString = String.valueOf(chars);

                // If sorted substring has been seen before
                if(map.containsKey(currentSubString)) 
                {
                    // Check how many times we've seen it and add that amount to the count
                    int value = map.get(currentSubString);
                    totalCount=totalCount+value;

                    // Increment the times we've seen the string
                    map.put(currentSubString, value+1);
                } 
                else 
                {
                    // Never seen it before = insert and set to 1 to indiciate we've now seen it
                    map.put(currentSubString, 1);
                }
            }
        }
        return totalCount;
       
    }
}
