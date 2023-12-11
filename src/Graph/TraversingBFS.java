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
public class TraversingBFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //TAKING INPUT OF GRAPH IN MATRIX REPRESENTATION:
        int n;//NO . of VERTEX
        int e; //NO. of edge
        n = sc.nextInt();
        int[][] edge = new int[n][n];
        e = sc.nextInt();
        int sv, fv;
        for (int i = 0; i < e; i++) {
            fv = sc.nextInt()-1;
            sv = sc.nextInt()-1;
            edge[sv][fv] = 1;
            edge[fv][sv] = 1;

        }
        //INPUT DONE

        print(edge);
    }


    /**
     * BFS
     */
    public static void print(int[][] edge)
    {
        boolean[] visited=new boolean[edge.length];
        for(int i=0;i< edge.length;i++)
        {
            if(!visited[i])
                printHelper(edge, i, visited);
        }

    }

    /**
     *
     *
     * BFS does not uses recursion
     */
    public static void printHelper(int[][] edge,int sv, boolean[] visited){
        Queue<Integer> pending=new LinkedList<>();
        pending.add(sv);
        visited[sv]=true;
        while(!pending.isEmpty())
        {
            int no=pending.poll();
            System.out.print(no+" ");
            for(int i=0;i< edge.length;i++)
            {
                if(edge[no][i]==1 && !visited[i])
                {
                    pending.add(i);
                    visited[i]=true;
                }
            }
//            System.out.println(pending);

        }
    }
}
/**
 * 7
 * 8
 * 1 2
 * 1 3
 * 2 4
 * 2 5
 * 3 6
 * 4 7
 * 5 7
 * 6 7
 *
 * GRAPH:
 *                                           0
 *                                          / \
 *                                         1   2
 *                                        / \   \
 *                                       3   4   5
 *                                       \   /  /
 *                                        \ / /
 *                                         \/
 *                                          6
 */