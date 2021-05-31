package com.hacker.rank.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Abbreviation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String a = bufferedReader.readLine();

                String b = bufferedReader.readLine();

                String result = abbreviationOptimal(a, b);
                System.out.println(result);
                // bufferedWriter.write(result);
                // bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        // bufferedWriter.close();
    }

    public static String abbreviation(String a, String b) {
        int aPosition=0;
        for(int i=0;i<b.length();i++){
            int smallCapMatchPosition=aPosition;
            if(a.length()<b.length()){
                return "NO";
            }
            if(aPosition>=a.length()){
                return "NO";
            }
            if(b.charAt(i)==(a.charAt(aPosition))){
                aPosition++;
                continue;
            }
            boolean isCapitalMatch=false;
            boolean isSMallCapMatch=false;
            int k=smallCapMatchPosition;
            int capitalMatchPosition=0;
            boolean aCapital=false;
            while(smallCapMatchPosition<a.length()&&!aCapital){
                //check if b matches capital letter
                  
                  if(b.charAt(i)==((a.charAt(smallCapMatchPosition)-32))){
                    k=smallCapMatchPosition;
                    smallCapMatchPosition++;
                    isSMallCapMatch=true;
                    continue;
                    
                } else if(b.charAt(i)==(a.charAt(smallCapMatchPosition))){
                    capitalMatchPosition=smallCapMatchPosition;
                    isCapitalMatch=true;
                    aCapital=true;
                    continue;
                } else if(b.charAt(i)!=a.charAt(smallCapMatchPosition)&& a.charAt(smallCapMatchPosition)<'a'){
                    aCapital=true;
                  continue;
                }
                    else {
                    smallCapMatchPosition++;
                }
            }
            aPosition=isCapitalMatch?++capitalMatchPosition:++k;
            if(!isSMallCapMatch&& !isCapitalMatch){
                return "NO";
            }
            
            
        }
        while(aPosition<a.length()){
            if(a.charAt(aPosition)<'a'){
                return "NO";
            }
            aPosition++;
        }
    return "YES";
    }
    /*public static String abbreviation(String a, String b) {
        Map<Character, Integer> mapCapitalA = getCharacterCapitalMap(a);
        System.out.println(mapCapitalA);
        Map<Character, Integer> mapSmallA = getCharacterASmallMap(a);
        System.out.println(mapSmallA);
        Map<Character, Integer> mapB = getCharacterBMap(b);
        System.out.println(mapB);
        if (a.length() < b.length()) {
            return "NO";
        }
        Iterator<Entry<Character, Integer>> it = mapB.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Character, Integer> entry = it.next();
            if (mapCapitalA.containsKey(entry.getKey())) {

                Integer value = mapCapitalA.get(entry.getKey());
                Integer valueB=entry.getValue().intValue();
                if(entry.getValue()>=value){
                    valueB=entry.getValue()-value;
                    value=0;
                }else {
                    value=value-entry.getValue();
                    valueB=0;
                }
                
                
                if (value <= 0) {
                    mapCapitalA.remove(entry.getKey());
                } else {
                    mapCapitalA.put(entry.getKey(), value);
                }
                if(valueB>=1){
                   mapB.put(entry.getKey(), valueB);
                } else {
                    it.remove();
                }
                
                
            } 
            
        }
        if(!mapCapitalA.isEmpty()){
            return "NO";
        }
        Iterator<Entry<Character, Integer>> itB2 = mapB.entrySet().iterator();
        while (itB2.hasNext()) {
            Entry<Character, Integer> entry = itB2.next();
         if (mapSmallA.containsKey(entry.getKey())) {
            Integer value = mapSmallA.get(entry.getKey());

            if (value.intValue() < entry.getValue().intValue()) {
                return "NO";
            }
        } 
         else {
            return "NO";
        }
        }
        return "YES";
    }*/

    static Map<Character, Integer> getCharacterASmallMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character ab = s.charAt(i);
            int compare= ab.compareTo('a');
             if(compare>=0){
                Integer value = map.get(Character.toUpperCase(ab));
                if (value == null) {
                    value = 1;
                    ;
                } else {
                    value = value + 1;
                }
                map.put(Character.toUpperCase(ab), value);
             }

        }
        return map;
    }
    
    static Map<Character, Integer> getCharacterBMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character ab = s.charAt(i);
             
                Integer value = map.get(ab);
                if (value == null) {
                    value = 1;
                    ;
                } else {
                    value = value + 1;
                }
                map.put(ab, value);
             

        }
        return map;
    }
    
    static Map<Character, Integer> getCharacterCapitalMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character ab = s.charAt(i);
           int compare= ab.compareTo('a');
            if (compare<0) {
                Integer value = map.get(ab);
                if (value == null) {
                    value = 1;
                    ;
                } else {
                    value = value + 1;
                }
                map.put(ab, value);
            } 

        }
        return map;
    }
    
   /* public static boolean abbreviationDP(String a, String b){
        if(a.length()<b.length()){
            return false;
        }
        boolean res=true;
        if(a.charAt(a.length()-a.length())<'a'){
           res= abbreviationDP(a.substring((a.length()-a.length())-a.length()-1), b);
        }else{
            if(a.charAt(a.length()-a.length())==b.charAt(b.length()-b.length())){
                abbreviation(a.length()-1, b)
                return true;
            }
        }
        return res;
        
    }
    */
    
    static String abbreviationOptimal(String a, String b) {
        // Complete this function
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        boolean[][] dp = new boolean[x.length + 1][y.length + 1];

        // 0 consumed from a, 0 consumed from b is reachable position
        dp[0][0] = true;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j <= y.length; j++) {
                // Delete lowercase char from a
                if (Character.isLowerCase(x[i])) {
                    dp[i + 1][j] |= dp[i][j];
                }

                // Match characters, make sure char from a is upper case
                if (j < y.length && Character.toUpperCase(x[i]) == y[j]) {
                    dp[i + 1][j + 1] |= dp[i][j];
                }
            }
        }

        return dp[x.length][y.length] ? "YES" : "NO";
    }
}
