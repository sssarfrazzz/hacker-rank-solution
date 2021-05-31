package com.hacker.rank.solution;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxArraySum {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        System.out.println(res);

        scanner.close();
    }

    static int maxSubsetSum(int[] arr) {
        boolean allNeagtive = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                allNeagtive = false;
                break;
            }
        }
        if (allNeagtive) {
            return 0;
        }

        if (arr.length == 1) {
            return arr[0];
        }
        int maxValue = arr[0];
        int max2Prev = arr[0];
        int max1Prev = arr[0];
        if (arr[0] < arr[1]) {
            maxValue = arr[1];
        }

        for (int i = 2; i < arr.length; i++) {
            max1Prev = maxValue;
            boolean tempMax = false;
            boolean tempMax2 = false;
            if (maxValue < arr[i]) {
                tempMax = true;
            }
            if (max2Prev + arr[i] > maxValue) {
                tempMax2 = true;
                ;
            }
            if (tempMax && tempMax2) {
                maxValue = Math.max(arr[i], arr[i] + max2Prev);
            } else if (tempMax2) {
                maxValue = arr[i] + max2Prev;

            } else if (tempMax) {
                maxValue = arr[i];
            }
            max2Prev = max1Prev;

        }

        return maxValue;
    }
}
