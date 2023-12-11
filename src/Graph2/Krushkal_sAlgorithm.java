package Graph2;

import org.w3c.dom.ls.LSOutput;
/*



Code : Kruskal's Algorithm
Send Feedback
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
For printing MST follow the steps -
1. In one line, print an edge which is part of MST in the format -
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note : Order of different edges doesn't matter.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
Output Format :
Print the MST, as described in the task.
Constraints :
2 <= V, E <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Input Graph

Sample Output 1 :
1 2 1
0 1 3
0 3 5

 */
import java.util.*;

public class Krushkal_sAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
            int n = sc.nextInt();
            int e = sc.nextInt();

            Edge[] input = new Edge[e];

            for (int i = 0; i < input.length; i++) {
                int sv = sc.nextInt();
                int fv = sc.nextInt();
                int w = sc.nextInt();
                input[i] = new Edge(sv,fv,w);

            }
            KrushKal(input, n);


        }
    }

    public static void KrushKal(Edge[] input, int n) {

        Comparator<Edge> ob = (o1, o2) -> o1.weight > o2.weight ? 1 : -1;


        Arrays.sort(input, ob);
//        for(int i=0;i<input.length;i++)
//            System.out.println(input[i]);

        int[] parent = new int[n];
        Edge[] output = new Edge[n - 1];

//        for (int i = 0; i < n-1; i++)
//            output[i]=new Edge();

        for (int i = 0; i < n; i++)
            parent[i] = i;

        int count =0;
        int i = 0;

        while (count != n - 1) {
            Edge currentEdge=input[i];
//            Edge currentEdge = new Edge();
//            currentEdge.weight=input[i].weight;
//            currentEdge.sv=input[i].sv;
//            currentEdge.fv=input[i].fv;

            int sourceParent = findParent(currentEdge.sv, parent);
            int destParent = findParent(currentEdge.fv, parent);


            // If their parents not equal, then we added that edge to output

            if (sourceParent != destParent) {
                output[count] = currentEdge;
//                System.out.println(output[i]);
                count++;               // Increased the count
                parent[sourceParent] = destParent;//Updated parent array
            }
            i++;
        }

        for (i = 0; i < n - 1; i++) {
            if (output[i].sv < output[i].fv) {
                System.out.println(output[i].sv + " " +
                        output[i].fv + " " + output[i].weight);
            } else {
                System.out.println(output[i].fv + " " +
                        output[i].sv + " " + output[i].weight);
            }
        }


    }


    public static int findParent(int v, int[] parent) {
        // Function to find the  parent of a vertex
        if (parent[v] == v) { // Base case, when a vertex is parent of itself
            return v;
        }
        // Recursively called to find the topmost parent of the vertex.
        return findParent(parent[v], parent);


    }
}


/*
Input:
1
5 7
1 2 2
1 3 10
1 0 3
2 0 8
3 4 11
4 0 5
3 0 4


Output:
1 2 2
0 1 3
0 3 4
0 4 5


 */



