package com.hacker.rank.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class SalesByMatch {

    public static class  Hashing{
       
        public static void main(String[] args) throws IOException {
           
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

             int n = Integer.parseInt(bufferedReader.readLine().trim());

             List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                     .map(Integer::parseInt)
                     .collect(toList());
            System.out.println(sockMerchant(n, ar));
        }
        
        
        public static int sockMerchant(int n, List<Integer> ar) {
            Map<Integer, List<Integer>>map=new HashMap<>();
            // Write your code here
            ar.stream().forEach(i->{
              if(map.containsKey(i)){
                  map.get(i).add(i);
              } else {
                  List<Integer>arr=new ArrayList<>();
                  arr.add(i);
                  map.put(i, arr);
              }
            });
            Iterator<Entry<Integer, List<Integer>>> it=map.entrySet().iterator();
            int count=0;
            while (it.hasNext()) {
               int size=it.next().getValue().size();
               int pair=size/2;
               count=count+pair;
                
            }
            return count;
            }
    }
    
   
    public static class IntegerArray{
        int [] value;
    }
}
