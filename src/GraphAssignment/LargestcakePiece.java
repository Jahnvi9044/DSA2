package GraphAssignment;

import java.util.*;
//Output for the give code =5 in the main function

/**
 *
 *
 * input:
 * 1 0 0
 * 0 1 0
 * 0 1 0
 *
 * output=2
 *
 */
public class LargestcakePiece {

    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
         int N=3;
         int M=3;

         int[][] graph={{1,1,1},
                        {0,1,0},
                        {0,1,0}
                        };
         boolean[][] visited=new boolean[N][M];
         int max=0;
         for(int i=0;i<N;i++) {
             for (int j = 0; j < M; j++) {
                 if (!visited[i][j] && graph[i][j] == 1)
                 {

                    int smAns= checkPiece(i, j, visited, graph, N, M);
                     if (smAns> max)
                     {
                         max=smAns;
                     }

                 }
             }
         }

            System.out.println("Largest Piece "+max);
             }

    }


    public static int   checkPiece(int i, int j,boolean[][] visited,int[][] graph,int  N,int  M)
    {
         int count=1;
         visited[i][j]=true;

//         Calls

        for(int k=0;k<dir.length;k++)
        {

            int x=i+dir[k][0];
            int y=j+dir[k][1];
            if(x<N && x>=0 && y<M && y>=0 && graph[x][y]==1 && !visited[x][y])
            {
                count+=checkPiece(x,y,visited,graph,N,M);
            }
        }
        return count;
    }
}
