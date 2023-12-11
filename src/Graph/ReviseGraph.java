package Graph;

import java.util.*;

public class ReviseGraph {

    //BFS AD LIST

   static  List<List<Integer>>  adjList = new ArrayList<>(100001);
   static  boolean[] visited =new boolean[100001];
   static int[] dist=new int[100001];

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();
        for(int i=1;i<=n+1;i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++)
        {
            int fv=sc.nextInt();
            int sv=sc.nextInt();

            adjList.get(sv).add(fv);
            adjList.get(fv).add(sv);
        }



        int s=sc.nextInt();
        int f=sc.nextInt();


        System.out.println(adjList);

//       for(int i=0;i<n+1;i++)
//            if(!visited[i])
//                dfsTraversal(i);

        bfsGetPath(s,f);
        System.out.print(s);

//        System.out.println();

//       for(int i=1;i<n+1;i++){
//           System.out.println("dist of "+i+": "+dist[i]);
//       }

    }



    public static void bfsGetPath(int sv, int f)
    {
        Queue<Integer> pending=new LinkedList<Integer>();
        HashMap<Integer,Integer> map=new HashMap<>();
         map.put(sv,-1);
        pending.add(sv);
        visited[sv]=true;
        while(!pending.isEmpty())
        {   int s= pending.poll();
            System.out.print(s+"-->");

            for(int i:adjList.get(s))
            {  if(!visited[i] )
               {
                pending.add(i);
                visited[i]=true;
                map.put(i,s);
               }
               if(f==i)
            {
                while(map.get(i)==-1)
                {
                    System.out.println(i+" ");
                }

            }
        }

    }

    }






        public static boolean dfsGetPath(int s, int f)
    {    visited[s]=true;
        if(s==f)
            return true;



        for(int i : adjList.get(s))
        {  if(!visited[i])
            if(dfsGetPath(i,f) && visited[i])
            {
                System.out.print(i+"-->");
                return true;
            }
        }

        return false;

    }



    public static void dfsTraversal(int sv)
    {
        System.out.print(sv+"-->");
        visited[sv]=true;
        for(int i:adjList.get(sv))
        {
            if(!visited[i])
                dfsTraversal(i);
        }
    }


    public static void bfsTraversal(int sv){
        Queue<Integer> pending=new LinkedList<Integer>();
        pending.add(sv);
        visited[sv]=true;
        while(!pending.isEmpty())
        {   int s= pending.poll();
            System.out.print(s+"-->");

            for(int i:adjList.get(s))
            {  if(!visited[i] )
                {
                    pending.add(i);
                    visited[i]=true;
                    dist[i]=dist[s]+1;
                }

            }
        }

    }


}
