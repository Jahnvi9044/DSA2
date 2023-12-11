package GraphPractice;


import java.util.*;

public class Kruskal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
        {

            int n=sc.nextInt();
            int e=sc.nextInt();
            Edge[] input =new Edge[e];
            Edge[] output =new Edge[n-1];
            int[] parent=new int[n];
            for(int i=0;i<n;i++)
                parent[i]=i;
            for(int i=0;i<e;i++)
            {
                int s=sc.nextInt();
                int f=sc.nextInt();
                int w=sc.nextInt();

                input[i]=new Edge(s,f,w);

            }

            Comparator<Edge> ob=(o1,o2)->(o1.weight<o2.weight)?-1:1;

            Arrays.sort(input,ob);
//            System.out.println("Sorted array is as follows ");

            int i=0,count=0;
            int sum=0;
            while(count!=n-1)
            {
                Edge edge=input[i];
                i++;
                int s=edge.source;
                int f=edge.dest;
                int w=edge.weight;


                int sp=FindParent(s,parent);
                int fp=FindParent(f,parent);

                if(sp!=fp)
                {
                    output[count]=edge;
                    parent[s]=fp;
                    count++;
                    sum+=w;

                }

            }


            for( i=0;i<count;i++)
            {
                output[i].EdgePrint();
            }

            System.out.println("Minimum Spanning Cost ="+sum);

        }

    }

    public static int FindParent(int i, int[] parent)
    {
        int pi=parent[i];
        if(pi==i) return pi;
       return  FindParent(pi,parent);

    }

}
