package hackerrank.graphs.find_nearest_clone;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val){
        // Check trivial case:
        int count = 0;
        for(int i=0; i<ids.length; i++){
            if(ids[i] == ids[val-1])
                count++;
        }
        if(count == 1){
            return -1;
        }

        // BFS:
        int[] distances = new int[graphNodes];
        Arrays.fill(distances, -1);
        distances[val-1] = 0;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(val);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor: findNeighbors(graphFrom, graphTo, node)){
                if(distances[neighbor-1] == -1){
                    distances[neighbor-1] = distances[node-1]+1;
                    queue.add(neighbor);
                }
                if(ids[neighbor-1] == ids[val-1] && neighbor != val)
                    return distances[neighbor-1];
            }
        }
        return -1;
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
