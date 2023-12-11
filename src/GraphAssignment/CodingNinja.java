package GraphAssignment;

import java.util.*;

public class CodingNinja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (t-- > 0) {//Write your code here



            String[] Graph={"DANDO",
                    "NNINJ",
                    "AXGJC",
                    "INJAA",
                    "CODDI"};

            int N=5;
            int M=5;
            System.out.println("Ans of graph 1"+solve(Graph , N, M));



           String[]  graph2={ "CANI",
                     "OOJN",
                     "DDIG",
                     "JNIN"};


            System.out.println("Ans of graph 2"+solve(graph2 , 4, 4));

        }

    }



       public static  int solve(String[] Graph , int N, int M)
        {
            /* Your class should be named Solution
             * Don't write main().
             * Don't read input, it is passed as function argument.
             * Return output and don't print it.
             * Taking input and printing output is handled automatically.
             */

            boolean[][] visited=new boolean[N][M];
            char[][] edge=new char[N][M];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<M;j++)
                {
                    edge[i][j]= Graph[i].charAt(j);
                    //  System.out.print(edge[i][j]+" ");
                }
                // System.out.println();
            }


            for(int i=0;i<N;i++)
            {
                for(int j=0;j<M;j++)
                {
                    if(!visited[i][j] && edge[i][j]=='C')
                    {
                        if(goAndVisit(i,j, visited, edge,"ODINGNINJA",N,M)==1)
                            return 1;

                    }
                }
            }


            return 0;
        }

        private static int goAndVisit(int i,int j, boolean[][] visited, char[][] edge ,String st,int n,int m)
        {


// System.out.println(ch);
// 	System.out.println(st);
//    System.out.println(i+" "+j);
            if(st.length()<=0)
            {
                //  System.out.println("AnsFound");
                return 1 ;
            }
            char ch=st.charAt(0);
            visited[i][j]=true;


            int[] diffx={-1,-1,-1,0,0,1,1,1};
            int[] diffy={-1,0,1,-1,1,-1,0,1};

            for(int k=0;k<diffx.length;k++)
            {
                int x = i+diffx[k] ;
                int y = j+diffy[k] ;

                if((x<n && y<m) &&(x>=0 && y>=0) && edge[x][y]==ch && !visited[x][y])
                { if( goAndVisit(x, y, visited, edge, st.substring(1), n, m)==1)
                    return 1;
                    visited[x][y]=false;
                }

            }


            return 0;

        }



}
