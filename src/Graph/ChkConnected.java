package Graph;

import java.util.*;

public class ChkConnected {
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
            fv = sc.nextInt();
            sv = sc.nextInt();
            edge[sv][fv] = 1;
            edge[fv][sv] = 1;
        }
        System.out.println(isConnected(edge));
    }

    public static boolean isConnected(int[][] edge)
    {    boolean[] visited=new boolean[edge.length];

            dfs(edge,0,visited);
         for(int i=0;i< edge.length;i++)
         {   if(!visited[i])
             return false;
         }
        return true;
    }

    public static void dfs(int[][] edge,int sv, boolean[] visited)
    {
        visited[sv]=true;
        for(int i=0;i<edge.length;i++)
        {    if( edge[sv][i]==1 && !visited[i])
             {
               dfs(edge,i,visited);
             }
        }
    }
}
