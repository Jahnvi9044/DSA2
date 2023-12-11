package Graph;

import java.util.*;

public class DfsAdjacencyList {

    static List<List<Integer>> adjList =new ArrayList<List<Integer>>(100001);
    static boolean[] visited = new boolean[100001];

    public static void dfs(int sv)
    {
        System.out.print(sv+"-->");
        visited[sv]=true;

        for(int i: adjList.get(sv))
        {
            if(!visited[i])
              dfs(i);

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n,e;
         int sv,fv;

         n=sc.nextInt();
         e=sc.nextInt();

         for(int i=0;i<n;i++)
         {
             adjList.add(new ArrayList<>());
         }
         for(int i=0;i<e;i++)
         {
             sv=sc.nextInt();
             fv=sc.nextInt();

             adjList.get(sv).add(fv);
             adjList.get(fv).add(sv);
         }

         for(int i=0;i<n;i++)
         {
             if (!visited[i])
                 dfs(i);
         }

    }
}
//9 10
//0 8
//1 6
//1 7
//1 8
//5 8
//6 0
//7 3
//7 4
//8 7
//2 5
//3 8