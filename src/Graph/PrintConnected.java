package Graph;

import java.util.*;

public class PrintConnected {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();
        int[][] edge=new int[n][n];
        for(int i=0;i<e;i++)
        {
            int fv=sc.nextInt();
            int sv=sc.nextInt();
            edge[sv][fv]=1;
            edge[fv][sv]=1;
        }
        printConnected(edge);


    }

    public static void printConnected(int[][] edge){
        boolean[] visited=new boolean[edge.length];
        for(int i=0;i< edge.length;i++)
        {
            if(!visited[i])
            {   ArrayList<Integer> arr=new ArrayList<>();
                printConnectedHelper(edge, i, visited, arr);
                System.out.println();
                Collections.sort(arr);
                for(int j=0;j<arr.size();j++)
                   System.out.print(arr.get(j)+" ");
            }

        }
    }

    public static void printConnectedHelper(int[][] edge, int sv, boolean[] visited , ArrayList<Integer> arr){
        arr.add(sv);
//        System.out.print(sv+" ");
        visited[sv]=true;

        for(int i=0;i< edge.length;i++)
        {   if(edge[sv][i]==1 && !visited[i])
               printConnectedHelper(edge,i,visited,arr);
        }

    }
}
