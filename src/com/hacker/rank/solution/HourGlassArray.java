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

public class HourGlassArray {

    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = hourglassSum(arr);
System.out.println(result);
      

        bufferedReader.close();
       
    }
    
    public static int hourglassSum( List<List<Integer>> arr ){
        List<Integer>hourGlassSum=new ArrayList<Integer>();
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++) {
            int r1=arr.get(i).get(j)+arr.get(i).get(j+1)+arr.get(i).get(j+2);
            int r2=arr.get(i+1).get(j+1);
            int r3=arr.get(i+2).get(j)+arr.get(i+2).get(j+1)+arr.get(i+2).get(j+2);
            hourGlassSum.add(r1+r2+r3);
            }
        }
        int maxHourGlass=-63;
        for (Integer hourGlass : hourGlassSum) {
          
            if(hourGlass>maxHourGlass){
                maxHourGlass=hourGlass;
            }
        }
        return maxHourGlass;
    }
}
