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

public class RepeatedStrings {

    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = repeatedString(s, n);

        System.out.println(result);

        bufferedReader.close();
        
    }
    
    static long repeatedString(String s, long n){
        int stringLength=s.length();
        long aCount=findA(s);
        long quotient=n/stringLength;
        int remainder=(int)(n%stringLength);
        long remAcount=0;
        if(remainder>0){
            remAcount=findA(s.substring(0,remainder));
        }
        long result=(long)aCount*quotient+(long)remAcount;
        return result;
    }
    
    static long findA(String s){
        long aCount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a')
            {
                aCount++;
            }
        }
        return aCount;
    }
}
