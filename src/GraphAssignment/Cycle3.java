package GraphAssignment;

import java.util.*;
import java.io.*;

/**
   input:
 1
 6 9
 4 3
 4 0
 0 3
 3 1
 5 1
 5 3
 0 5
 0 2
 5 2


 output:4
Question::
 Given a graph with N vertices (numbered from 0 to N-1) and M undirected edges, then count the distinct 3-cycles in the graph. A 3-cycle PQR is a cycle in which (P.Q), (Q.R) and (R,P) are connected by an edge.
 Input Format:
 The first line of input contains two space separated integers, that denotes the value of N and M. Each of the following M lines contain two integers. that denote the vertices which have an undirected edge between them. Let us denote the two vertices with the symbol u and v.
 Output Format:
 Print the count the number of 3-cycles in the given graph
 */
public class Cycle3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws NumberFormatException, IOException{

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
            boolean[][] graphs = takeInput();

            int ans = solve(graphs, graphs.length);
            System.out.println(ans);
        }
    }

        public static int solve(boolean[][] graph, int n) {

            /*
             * Your class should be named Solution
             * You may write your code here
             */



            int count=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {  if(graph[i][j] && i!=j)
                    for(int k=0;k<n;k++)
                    {
                        if(i!=k && k!=j && graph[j][k])
                        {
                            if(graph[k][i])
                                count++;
                        }
                    }
                }
            }

            return count/6;
        }

        public static boolean[][] takeInput() throws IOException {
            String[] strNums;
            strNums = br.readLine().split("\\s");
            int n = Integer.parseInt(strNums[0]);
            int m = Integer.parseInt(strNums[1]);

            boolean[][] graphs = new boolean[n][n];
            int firstvertex, secondvertex;

            for (int i = 0; i < m; i++) {
                String[] strNums1;
                strNums1 = br.readLine().split("\\s");
                firstvertex = Integer.parseInt(strNums1[0]);
                secondvertex = Integer.parseInt(strNums1[1]);
                graphs[firstvertex][secondvertex] = true;
                graphs[secondvertex][firstvertex] = true;
            }
            return graphs;
        }


    }
