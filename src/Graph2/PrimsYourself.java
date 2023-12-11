package Graph2;

import java.util.*;

public class PrimsYourself {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

          primsAlgo(v , adjMatrix);




    }

    public static void primsAlgo(int v, int[][] adjMatrix){

        int[] parent=new int[v];
        int[] weight=new int[v];
        boolean[] visited=new boolean[v];

        for(int i=0;i<v;i++)
        {
            weight[i]=Integer.MAX_VALUE;
        }

        parent[0]=-1;
        weight[0]= 0;
//v(log v+E)
        for(int i=0;i<v;i++)//v
        {
           int minVertex=findMinVertex(weight,visited); //o(log V)
            visited[minVertex]=true;
            for(int j=0;j<v;j++) //E
            {

                if(!visited[j] && adjMatrix[minVertex][j]!=0)
                {

                    if(adjMatrix[minVertex][j]<weight[j])
                    {
                        weight[j] = adjMatrix[minVertex][j] ;
                        parent[j]=minVertex;
                    }
                }

            }
        }

        for(int i=1;i<v;i++)
        {
            if(parent[i]<i)
            {
                System.out.println(parent[i]+" "+i+" "+weight[i]);
            }
            else
            {
                System.out.println(i+" "+parent[i]+" "+weight[i]);
            }
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
