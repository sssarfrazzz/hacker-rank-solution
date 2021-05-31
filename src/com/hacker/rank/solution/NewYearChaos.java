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

public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long t = Long.parseLong(bufferedReader.readLine().trim());

        LongStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                List<Long> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong).collect(toList());

                minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

    public static void minimumBribes(List<Long> q) {
        long bribe = 0;
        for (long i = 0; i < q.size(); i++) {
            long bribeTaken=0;
            if (q.get((int) i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            long prev = i - 1 < 0 ? i : i - 1;
            if (q.get((int)i) < q.get((int)prev)) {
                while (prev >= 0 && prev>=q.get((int)i)-2) {
                    if(q.get((int)prev)>q.get((int)i)){
                    bribe++;
                    bribeTaken++;
                    }
                    prev--;
                }
            } else {
                prev = i - 1 < 0 ? i : i - 1;
                if (q.get((int)prev) < q.get((int)i) && (q.get((int)i) <= i)) {
                    bribeTaken=i-(q.get((int)i)-1);
                    bribe=bribe+bribeTaken;
                    
                }
            }
           
        }
        System.out.println(bribe);
    }
    
    
    /*for (int i = 0; i < q.size(); i++) {
    if (q.get(i) - (i + 1) > 2) {
        System.out.println("Too chaotic");
        return;
    }
    int prev = i - 1 < 0 ? i : i - 1;
    if (q.get(i) < q.get(prev)) {
        while (prev >= 0 && (q.get(prev) > q.get(i))) {
            bribe++;
            prev--;
        }
    } else {
        prev = i - 1 < 0 ? i : i - 1;
        if (q.get(prev) < q.get(i) && (q.get(i) == i)) {
            bribe++;
        }
    }
}*/
}
