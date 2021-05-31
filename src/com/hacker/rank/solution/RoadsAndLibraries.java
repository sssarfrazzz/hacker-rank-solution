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

public class RoadsAndLibraries {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = roadsAndLibraries(n, c_lib, c_road, cities);
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
    
    public static long roadsAndLibraries(int n,  int clib, int c_road,List<List<Integer>> cities){
        Map<Integer, List<Integer>> adj = new HashMap<>();
        HashMap<Integer, Boolean>visited=new HashMap<>();
        Set<Integer>vertex=new HashSet<>();
       
        for (List<Integer> rd : cities) {
           
            int cityA=rd.get(0);
            int cityB=rd.get(1);
            vertex.add(cityA);
            vertex.add(cityB);
            adj=addInAdjecancy(adj, cityA, cityB);
            adj=addInAdjecancy(adj, cityB, cityA); 
            visited.put(cityA, false);
            visited.put(cityB, false);
        }
            for(int i=0;i<vertex.size();i++){
                
            }
                        
                        
                        /*new Comparator<T>()
                        {

                            @Override
                            public int compare(T o1, T o2) {
                               List<Integer>l1=(List<Integer>)o1;
                               List<Integer>l22=(List<Integer>)o1;
                               if(l1.size()==l2.size()){
                                   return 0;
                               } else if(l1.size()>l2.size()){
                                   return 1;
                               } else{
                                   return -1;
                               }
                                return 0;
                            }
                }))*/
                
        if(clib<c_road){
            return vertex.size()*clib;
        }
        int totalCost=0;
        
        for (Integer v : vertex) {
            if(!visited.get(v)){
                totalCost=totalCost+clib+DFSUtils(v, visited, adj, 1, c_road, clib);
            } 
        }
        return totalCost;
    }
    
    
    public static int  DFSUtils(int city, HashMap<Integer, Boolean>visited ,  Map<Integer, List<Integer>> adj, int libDIstance,int c_road, int clib){
        int cost=0;
        visited.put(city, true);
        for (Integer adjc : adj.get(city)) {
            if(!visited.get(adjc)&& libDIstance*c_road<clib){
               
               cost=cost+libDIstance*c_road;
               cost=cost+DFSUtils(adjc, visited, adj, libDIstance+1, c_road, clib);
            }
        }
       
        return cost;
    }
    
    public static Map<Integer, List<Integer>>addInAdjecancy(Map<Integer, List<Integer>> adj,int key,int vale){
        if(adj.containsKey(key)){
            List<Integer>LlA=adj.get(key);
            LlA.add(vale);
            adj.put(key, LlA);
        } else {
            List<Integer>LlA=new ArrayList<>();
            LlA.add(vale);
            adj.put(key, LlA);
        }
        
        return adj;
    }
    
   /* if(!visited[cityA]&& !visited[cityB]){
        visited[cityA]=true;
        visited[cityB]=true;
        queue.add(cityA);
        queue.add(cityB);
         if(cityA>cityB){
             isLibraryPresent.put(cityA, true);
             isRoadConnectedToLib.put(cityA, 0);
             isRoadConnectedToLib.put(cityB, c_road);
             Cost=(long)clib+(long)c_road;
         } else {
             isLibraryPresent.put(cityB, true);
             isRoadConnectedToLib.put(cityB, 0);
             isRoadConnectedToLib.put(cityA, c_road);
             Cost=(long)clib+(long)c_road;
         }
         
     } if(!visited[cityA]&& visited[cityB]){
         visited[cityA]=true;
         int rdDistancefromLib=isRoadConnectedToLib.get(cityB);
         if(rdDistancefromLib<clib){
             isRoadConnectedToLib.put(cityA,rdDistancefromLib+c_road );
             
         } else {
             
         }
         
     }*/
}
