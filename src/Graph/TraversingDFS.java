package Graph;

import java.util.*;

/**
 * REPRESENTATIONS OF GRAPH:
 *                          1.)  Edge List : SC=O(n+E)   TC=O(n^2)
 *
 *                          2.)  ArrayList : SC=O(n+2E)  TC=O(n)
 *
 *                          3.)  Matrix : SC=O(n^2)      TC=O(1)
 *
 * TRAVERSING METHODS:
 *
 *                          1.) DFS
 *
 *                          2.) BFS
 *
 *
 */
public class TraversingDFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //TAKING INPUT OF GRAPH IN MATRIX REPRESENTATION:
        int n;//NO . of VERTEX
        int e; //NO. of edge
        n=sc.nextInt();
        int[][] edge=new int[n][n];
        e=sc.nextInt();
        int sv,fv;
        for(int i=0;i<e;i++)
        {   fv=sc.nextInt();
            sv=sc.nextInt();
            edge[sv][fv]=1;
            edge[fv][sv]=1;

        }
        //INPUT DONE

        System.out.println("Traverse the graph DFS:");

        print(edge);


    }


    public static void print(int[][] edge) {

        boolean[] visited=new boolean[edge.length];
        for(int i=0;i<edge.length;i++)
        {
            if(!visited[i])
                printHelper(edge,i,visited);
        }

    }

    public static void printHelper(int[][] edge,int sv, boolean[] visited) {
        System.out.print(sv+" ");
        visited[sv]=true;
        for(int i=0;i<edge.length;i++)
        {    if( edge[sv][i]==1 && !visited[i])
             {
                 printHelper(edge,i,visited);
             }


        }

    }


}