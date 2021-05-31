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



public class CountingValleys {
    
    


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.tupleCount(steps, path);
System.out.println(result);
       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        bufferedReader.close();
      //  bufferedWriter.close();
    }

}



class Result {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
       int valleyCount=0;
       int currentSTep=0;
       int prevStep=0;
       for(int i=0;i<steps;i++){
           if(path.charAt(i)=='U')
           {
               prevStep=currentSTep;
               currentSTep++;
           } else {
               prevStep=currentSTep;
               currentSTep--;
           }
           if(currentSTep==0&& prevStep==-1){
               valleyCount++;
           }
       }
       return valleyCount;
    }
    
    
    public static int tupleCount(int steps, String path){
        int valleyCount=0;
        if (steps>2 && path!=null&& !path.isEmpty() && steps==path.length()) {
        for(int i=0,j=2;j<=steps;){
          String s= path.substring(i, j);
          char[] p=s.toCharArray();
          int k=0;
          boolean isValley=false;
        
         for (char c : p) {
            if(c=='U'){
                if(k==0){
                    isValley=false;
                }
                k++;
            }
            else {
                if(k==0){
                    isValley=true;
                }
                k--;
            }
            
        }
         if(k==0){
             i=j;
             j=i+2;
             if(isValley){
                 valleyCount++;
                 isValley=false;
             }
             
         }else{
            j++; 
         }
         }
        }
        return valleyCount;
    }

}


