package Graph2;

import java.util.*;

public class Dijkastra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here

            int v=sc.nextInt();
            int e=sc.nextInt();


            int[][] adjMatrix=new int[v][v];
            for(int i=0;i<e;i++)
            {

                int s=sc.nextInt();
                int d=sc.nextInt();
                int w=sc.nextInt();

                adjMatrix[s][d]=w;
                adjMatrix[d][s]=w;

            }

      DijkastraAlgo(v,adjMatrix);


        }

    }






    public static void DijkastraAlgo(int v, int[][] adjMatrix){


        int[] dist=new int[v];
        boolean[] visited=new boolean[v];

        for(int i=0;i<v;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }


        dist[0]= 0;
//v(log v+E)
        for(int i=0;i<v;i++)//v
        {
            int minVertex=findMinVertex(dist,visited); //o(log V)
            visited[minVertex]=true;
            for(int j=0;j<v;j++) //E
            {

                if(!visited[j] && adjMatrix[minVertex][j]!=0)
                {

                    if(adjMatrix[minVertex][j]+dist[minVertex]<dist[j])
                    {
                        dist[j] = adjMatrix[minVertex][j]+dist[minVertex] ;

                    }
                }

            }
        }
//the out should be vertex  its distance seperated by space

        System.out.println("vertex\t its distance");
        for(int i=0;i<v;i++)
        {

                System.out.println("\t"+i+"\t "+ dist[i]);

        }


    }


    public static int findMinVertex(int[] weight,boolean[] visited)
    {  int minvertex=-1;

        for(int i=0;i<weight.length;i++)
        {  if( !visited[i] && (minvertex==-1||weight[i]<weight[minvertex]))
            minvertex = i ;

        }

        return minvertex;
    }
}
/**
 * input:
 4 4
 0 1 3
 0 3 5
 1 2 1
 2 3 8


 output:

 0 1 3
 1 2 1
 0 3 5
 */
