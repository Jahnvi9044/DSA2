package Graph;

import java.util.*;

public class getPath2dfs {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);


            //TAKING INPUT OF GRAPH IN MATRIX REPRESENTATION:
            int v;//NO . of VERTEX
            int e; //NO. of edge
            v = sc.nextInt();
            int[][] edge = new int[v][v];
            e = sc.nextInt();
            int sv, fv;
            for (int i = 0; i < e; i++) {
                fv = sc.nextInt();
                sv = sc.nextInt();
                edge[sv][fv] = 1;
                edge[fv][sv] = 1;

            }
            //INPUT DONE
              sv= sc.nextInt();
              fv= sc.nextInt();
              boolean[]  visited =new boolean[v];
            System.out.println(getPath(sv,fv,visited,edge, v));



    }

    public static ArrayList<Integer> getPath(int s, int e ,boolean[] visited, int[][] edge, int v){

             if(s==e)
             {
                 ArrayList<Integer> arr=new ArrayList<>();
                 arr.add(0,s);
             }
              visited[s]=true;
        ArrayList<Integer> ans=new ArrayList<>();
             for(int i=0;i<v;i++)
             {

                 if(!visited[i] && edge[s][i]==1)
                 {
                    ans= getPath(i,e,visited,edge,v);
                     visited[i]=true;
                     ans.add(s);

                 }

             }

             return ans;

    }
}
