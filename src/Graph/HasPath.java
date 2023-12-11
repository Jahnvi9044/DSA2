package Graph;

import java.util.*;

/**
 * Code : Has Path
 * Send Feedback
 * Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. Print true if the path exists and false otherwise.
 * Note:
 * 1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
 * 2. E is the number of edges present in graph G.
 * Input Format :
 * The first line of input contains two integers, that denote the value of V and E.
 * Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
 * The following line contain two integers, that denote the value of v1 and v2.
 * Output Format :
 * The first and only line of output contains true, if there is a path between v1 and v2 and false otherwise.
 * Constraints :
 * 0 <= V <= 1000
 * 0 <= E <= 1000
 * 0 <= a <= V - 1
 * 0 <= b <= V - 1
 * 0 <= v1 <= V - 1
 * 0 <= v2 <= V - 1
 * Time Limit: 1 second
 * Sample Input 1 :
 * 4 4
 * 0 1
 * 0 3
 * 1 2
 * 2 3
 * 1 3
 * Sample Output 1 :
 * true
 * Sample Input 2 :
 * 6 3
 * 5 3
 * 0 1
 * 3 4
 * 0 3
 * Sample Output 2 :
 * false
 */
public class HasPath {
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
            int s=sc.nextInt();
            int f=sc.nextInt();
           // System.out.println("Traverse the graph DFS:");

            chk2(edge,s,f);


        }


        public static void chk(int[][] edge,int s,int f) {

            boolean[] visited=new boolean[edge.length];

            System.out.println(dfs(edge,s,f,visited));

        }

        public static boolean dfs(int[][] edge,int sv,int fv, boolean[] visited) {

            visited[sv]=true;
            for(int i=0;i<edge.length;i++)
            {    if( edge[sv][i]==1 && !visited[i])
                 {

                   if(i==fv) return true;
                   return dfs(edge,i,fv,visited);
                 }
            }
              return false;
        }



    public static void chk2(int[][] edge,int s,int f)
    {
        boolean[] visited=new boolean[edge.length];

        System.out.println( bfs(edge, s,f, visited));


    }

    public static boolean  bfs(int[][] edge,int sv,int fv, boolean[] visited){
        Queue<Integer> pending=new LinkedList<>();
        pending.add(sv);
        visited[sv]=true;
        while(!pending.isEmpty())
        {
            int no=pending.poll();
            for(int i=0;i< edge.length;i++)
            {
                if(edge[no][i]==1 && !visited[i])
                {

                    pending.add(i);
                    visited[i]=true;
                    if(fv==i)
                        return true;

                }
            }

        }
        return false;
    }
}

