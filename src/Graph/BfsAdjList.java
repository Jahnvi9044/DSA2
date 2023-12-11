package Graph;

import java.util.*;

public class BfsAdjList {

     static List<List<Integer>> adjList = new ArrayList<>(100001);
     static boolean[] visited=new boolean[100001];
     static int[] dist = new int[100001];
     public static void bfs(int sv)
     {
      //   System.out.print(sv+"-->");
         visited[sv]=true;
         Queue<Integer> pending =new LinkedList<>();
         pending.add(sv);

         while(!pending.isEmpty())
         {
             int s=pending.poll();
             System.out.print(s+"-->");
             for(int i: adjList.get(s))
             {
                 if (!visited[i])
                 {
                     pending.add(i);
                     dist[i]=dist[s]+1;
                     visited[i]=true;
                 }

             }

         }

     }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n,e;
        int sv,fv;

        n=sc.nextInt();
        e=sc.nextInt();

        for(int i=0;i<n+1;i++)
        {
            adjList.add(new ArrayList<>());

        }
        System.out.println(adjList);
        for(int i=0;i<e;i++)
        {
            sv=sc.nextInt();
            fv=sc.nextInt();

            adjList.get(sv).add(fv);
            adjList.get(fv).add(sv);

        }
        for(int i=1;i<n+1;i++) {
            if (!visited[i])
                bfs(i);
        }

        for(int i=1;i<n+1;i++)
            System.out.println("dist of "+i+" = " +dist[i]);

    }
}
