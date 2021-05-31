package com.hacker.rank.solution;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BeautifulSet {
    
    

    public static int beautifulPairs(List<Integer> A, List<Integer> B){
      int beaturfulset=0;
      List<Integer> indicesAused=new ArrayList<>(); 
      List<Integer> indicesBused=new ArrayList<>(); 
      System.out.println(A.size());
      System.out.println(B.size());
     for(int i=0;i<A.size();i++){
         for(int j=0;j<B.size();j++){
         if(A.get(i)==B.get(j)) {
            
           //  if(!indicesAused.contains(i) ||! indicesBused.contains(j)){
             System.out.println(i+","+j);
             indicesAused.add(i);
             indicesBused.add(j);
             beaturfulset++;
            //}
         }
         }
     }
      
      if(beaturfulset<A.size()){
          beaturfulset=beaturfulset+1;
      } else {
          beaturfulset=beaturfulset-1;
      }
      System.out.println(beaturfulset);
        return beaturfulset;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = beautifulPairs(A, B);


        bufferedReader.close();
    }
}
