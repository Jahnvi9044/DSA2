package Graph;


/**
 * Code : Get Path - BFS
 * Send Feedback
 * Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
 * Find the path using BFS and print the shortest path available.
 * Note:
 * 1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
 * 2. E is the number of edges present in graph G.
 * 3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
 * 4. Save the input graph in Adjacency Matrix.
 * Input Format :
 * The first line of input contains two integers, that denote the value of V and E.
 * Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
 * The following line contain two integers, that denote the value of v1 and v2.
 * Output Format :
 * Print the path from v1 to v2 in reverse order.
 * Constraints :
 * 2 <= V <= 1000
 * 1 <= E <= (V * (V - 1)) / 2
 * 0 <= a <= V - 1
 * 0 <= b <= V - 1
 * 0 <= v1 <= 2^31 - 1
 * 0 <= v2 <= 2^31 - 1
 * Time Limit: 1 second
 * Sample Input 1 :
 * 4 4
 * 0 1
 * 0 3
 * 1 2
 * 2 3
 * 1 3
 * Sample Output 1 :
 * 3 0 1
 * Sample Input 2 :
 * 6 3
 * 5 3
 * 0 1
 * 3 4
 * 0 3
 * Sample Output 2 :
 */

import java.util.*;

public class GetPath {
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
        //INPUT DONE
        int s=sc.nextInt();
        int f=sc.nextInt();
        getPathdfs(edge,s,f);
    }
    public static void getPathdfs(int[][] edge, int s, int f)
    {
        boolean[] visited=new boolean[edge.length];
        boolean found=false;
        if(dfs(edge,s,f,visited,found))
            System.out.println(s);
    }
    public static boolean  dfs(int[][] edge, int s,int f,boolean[] visited,boolean found)
    {    visited[s]=true;
        //System.out.println(s+"_");
         if(s==f)
         {
             return true;
         }
        for(int i=0;i< edge.length;i++)
        {
            if(edge[s][i]==1 && !visited[i])
            {
                if(dfs(edge,i,f,visited,found)&& visited[i])
                {
                    System.out.print(i + " ");
                    return true;
                }
            }
        }
        return false;
    }


    public static void getPathbfs(int[][] edge, int s, int f)
    {
        boolean[] visited=new boolean[edge.length];
        boolean found=false;
        bfs(edge,s,f,visited,found);
    }
    public static void bfs(int[][] edge, int s,int f, boolean[] visited, boolean found)
    {   Queue<Integer> pending=new LinkedList<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        pending.add(s);
        visited[s] = true;
        map.put(s,-1);
        while(!pending.isEmpty())
        {   int no=pending.poll();
            for(int i=0;i< edge.length;i++)
            {
                if(!visited[i] && edge[no][i]==1)
                {
                    pending.add(i);
                    visited[i]=true;

                    map.put( i , no /*parent*/ );

                    if(i == f)
                    {
                        //there is an existing path form s to f vertex
                        System.out.print(i+" ");
                        int path=map.get(i);
                        while(path!=-1)
                        {
                            System.out.print(path+" ");
                            path=map.get(path);
                        }

                    }


                }


            }

        }


    }
}
