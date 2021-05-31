package com.hacker.rank.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeaatifulSet3 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        System.out.println(n);
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(n-(n-i)+j);
                
                System.out.print(" " );
            }
            System.out.println();
        }
        
    }
    
}
