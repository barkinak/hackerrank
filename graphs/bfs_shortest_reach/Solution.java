package hackerrank.graphs.bfs_shortest_reach;

import java.io.*;
import java.util.*;

public class Solution {
    public static int EDGE_DIS = 6;

    public static void main(String[] args){
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());

        for(int i=0; i<q; i++){
            String[] graphNodesEdges = scanner.nextLine().split(" ");
            int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
            int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

            int[] graphFrom = new int[graphEdges];
            int[] graphTo = new int[graphEdges];

            for (int j=0; j<graphEdges; j++) {
                String[] graphFromTo = scanner.nextLine().split(" ");
                graphFrom[j] = Integer.parseInt(graphFromTo[0].trim());
                graphTo[j] = Integer.parseInt(graphFromTo[1].trim());
            }

            int startNode = Integer.parseInt(scanner.nextLine());
            printArray(bfs(graphNodes, startNode, graphFrom, graphTo));
        }
        scanner.close();
    }

    public static void printArray(ArrayList<Integer> arr){
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> bfs(int size, int startNode, int[] graphFrom, int[] graphTo){
        int[] distances = new int[size];
        Arrays.fill(distances, -1);
        distances[startNode-1]++;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor: findNeighbors(graphFrom, graphTo, node)){
                if(distances[neighbor-1] == -1){
                    distances[neighbor-1] = distances[node-1] + EDGE_DIS;
                    queue.add(neighbor);
                }
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<distances.length; i++){
            if(distances[i] != 0)
                arr.add(distances[i]);
        }
        return arr;
    }

    // Returns neighbors of a node:
    static ArrayList<Integer> findNeighbors(int[] graphFrom, int[] graphTo, int node){
        ArrayList<Integer> neighbors = new ArrayList<>();
        for(int i=0; i<graphFrom.length; i++){
            if(node == graphFrom[i])
                neighbors.add(graphTo[i]);
            if(node == graphTo[i])
                neighbors.add(graphFrom[i]);
        }
        return neighbors;
    }
}
