package GraphAssignment;

import java.util.*;
//question

/**
 * Gary has a board of size NxM. Each cell in the board is a coloured dot. There exist only 26 colours denoted by uppercase Latin characters (i.e. A,B....,Z). Now Gary is getting bored and wants to play a game. The key of this game is to find a cycle that contain dots of same colour. Formally, we call a sequence of dots d1, d2..... dk a cycle if and only if it meets the following condition:
 *  then di is different from dj.
 * 2. k is at least 4.
 * 3. All dots belong to the same colour.
 * 4. For all 1 sisk-1: di and di + 1 are adjacent. Also, dk and d1 should also be adjacent. Cells x and y are called adjacent if they share an edge.
 * Since Gary is colour blind, he wants your help. Your task is to determine if there exists a cycle on the board.
 *
 *
 *
 *
 * Input Format:
 * The first line of input contains two space separated integers N and M. where N is number of rows and M is the number of columns of the board.
 * Each of the following N lines contain M characters. Please note that characters are not space separated. Each character is an uppercase Latin letter.
 * Output Format:
 * For C++: Print true if there is a cycle in the board, else
 * print false. For Java: Print 1 if there is a cycle in the board, else
 * print 0.
 * Constraints:
 * 2 <= N <= 1000 2 <= M <= 1000 Time Limit: 1 second
 *
 *
 *
 * Sample Input 1:
 * 34
 * AAAA
 * ABCA
 * AAAA
 * Sample Output 1:
 * true
 *
 *
 * 7 6
 * AAAAAB
 * ABBBAB
 * ABAAAB
 * ABABBB
 * ABAAAB
 * ABBBAB
 * AAAAAB
 *
 * false
 */
public class CountDots {


    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)   {



            String[] Graph={ "AAAAAB",
                   "ABBBAB",
                   "ABAAAB",
                    "ABABBB",
                    "ABAAAB",
                    "ABBBAB",
                    "AAAAAB"};


            int N=7;
            int M=6;



            char[][] graph=new char[N][M];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<M;j++)
                {
                    graph[i][j]= Graph[i].charAt(j);
                    //  System.out.print(edge[i][j]+" ");
                }
                // System.out.println();
            }



            boolean[][] visited=new boolean[N][M];
        int flag=0;
        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] )
                {

                    int smAns= checkCircle(i, j, visited, graph, N, M,i,j,1);
                    if (smAns==1)
                    {
                        System.out.println("YES");
                        flag=1;
                        break;
                    }

                }
            }
            if(flag==1)
                break;
        }
            if(flag==1)
                continue;

            System.out.println("NO");
    }

}


    public static int   checkCircle(int i, int j,boolean[][] visited,char[][] graph,int  N,int  M,int s1,int s2,int count)
    {

        visited[i][j]=true;
//        System.out.println(i+" " +j);


//         Calls

        for(int k=0;k<dir.length;k++)
        {

            int x=i+dir[k][0];
            int y=j+dir[k][1];
            if(x<N && x>=0 && y<M && y>=0 && graph[x][y]==graph[i][j] && !visited[x][y])
            {
                if(checkCircle(x,y,visited,graph,N,M,s1,s2,count+1)==1)
                    return 1;
                visited[x][y]=false;
            }
            if(x==s1 && y==s2 && graph[x][y]==graph[i][j] && visited[x][y] && count>2)
            {
                return 1;
            }
        }
        return 0;
    }
}
