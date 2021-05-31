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

public class CompanyUniversity {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrivalCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arrival = IntStream.range(0, arrivalCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(toList());

        int durationCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> duration = IntStream.range(0, durationCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(toList());

        int result = maxEvents(arrival, duration);
        System.out.println(result);

        bufferedReader.close();
    }

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // Write your code here
        int count = 0;
        if(arrival.size()==1){
            return 1;
        }
        HashMap<Integer, List<Integer>> arrivalMap = new HashMap<>();
        for (int i = 0; i < arrival.size(); i++) {
            List<Integer> dur=null;
            if (arrivalMap.containsKey(arrival.get(i))) {
                dur = arrivalMap.get(arrival.get(i));
            } else {
               dur=new ArrayList<Integer>();
            }
            dur.add(duration.get(i));
            arrivalMap.put(arrival.get(i), dur);
        }
        Collections.sort(arrival);
        List<Integer>newDurationLIst=new ArrayList<Integer>();
        for(int i=0;i<duration.size();){
            int arr=arrival.get(i);
            List<Integer>list=arrivalMap.get(arr);
            Collections.sort(list);
            for (Integer integer : list) {
                newDurationLIst.add(integer);
                i++;
            }
        }
       /* System.out.println(arrivalMap);
        printList(arrival);
        printList(newDurationLIst);*/
        for (int i = 0; i < arrival.size() - 1; i++) {
            if (i == (arrival.size() - 2) && arrival.get(i) + newDurationLIst.get(i) <= arrival.get(i + 1)) {
                count = count + 2;
                continue;
            }
            if (arrival.get(i) + newDurationLIst.get(i) <= arrival.get(i + 1)) {
                count++;
            } else if (arrival.get(i) + newDurationLIst.get(i) > arrival.get(arrival.size() - 1)) {
                continue;
            } else {
               // for(int j=i, k=i+1;j<a)
            }
        }

        return count;
    }
    
    static void printList(List<Integer>print){
        for (Integer integer : print) {
            System.out.println(integer);
        }
    }
}
