package com.hacker.rank.solution;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Solution has passed 10 out of 11 Test cases. One Timeout has happened
 * @author Sarfraz Shaikh
 *
 */
public class NearestClone {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);
        System.out.println(ans);

        scanner.close();
    }

    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // create adjancyMap with key as ID
        // DFS on Id using adjacancy
        Map<Integer, List<Integer>> adjacancies = new HashMap<Integer, List<Integer>>();
        Map<Integer, Long> colorValue = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < graphFrom.length; i++) {
            int from = graphFrom[i];
            int to = graphTo[i];
            addInAdjecancy(adjacancies, from, to);
            addInAdjecancy(adjacancies, to, from);
        }
        List<Integer>startNodes = new ArrayList<Integer>();
        for (int i = 0; i < graphNodes; i++) {
            if (ids[i] == val ) {
                startNodes.add(i+1) ;
            }
            colorValue.put(i + 1, ids[i]);
            visited.put(i + 1, false);
        }
        int result=Integer.MAX_VALUE;
        for (Integer startNode : startNodes) {
            result=Math.min(result, DFSUtils(val, startNode, visited, adjacancies, colorValue, 0, Integer.MAX_VALUE));
        }
        if (result == 0|| result==Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    public static Map<Integer, List<Integer>> addInAdjecancy(Map<Integer, List<Integer>> adj, int key, int vale) {
        if (adj.containsKey(key)) {
            List<Integer> LlA = adj.get(key);
            LlA.add(vale);
            adj.put(key, LlA);
        } else {
            List<Integer> LlA = new ArrayList<>();
            LlA.add(vale);
            adj.put(key, LlA);
        }

        return adj;
    }

    public static int DFSUtils(int id, int node, Map<Integer, Boolean> visited, Map<Integer, List<Integer>> adj, Map<Integer, Long> colorValue, int depth, int minFOund) {
        int cost = minFOund;
        visited.put(node, true);
        for (Integer adjc : adj.get(node)) {
            if(cost!=1&& depth+1<cost){
                if (!visited.get(adjc)) {
                    if (id == colorValue.get(adjc))
                        cost = Math.min(cost, depth + 1);
                    else {
                        cost =DFSUtils(id, adjc, visited, adj, colorValue, depth + 1, cost);
                    }
                }
            } else {
                break;
            }
        }
        return cost;
    }
}
