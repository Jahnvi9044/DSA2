package Recursion;

import java.util.*;

public class Codechef_pyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


//        ITERATIVE>>>>>>>>>>>>>>
//        for(int i=1;i<=n;i++)
//        {
//            for(int s=n-1;s>i-1;s--)
//                System.out.print(" ");
//            for(int j=0;j<2*i-1;j++)
//                System.out.print("*");
//            System.out.println();
//        }

//        rec(n+1,1);
       StringBuffer sb=new StringBuffer();
       for(int s=n-1;s>=1;s--)
           sb.append(" ");
        sb.append("*");
        last(n+1, 1,sb);

    }

    public static void last(int n, int i,StringBuffer sb)
    {
        if(n<=i)
            return ;
        System.out.println(sb);
        sb.deleteCharAt(0);
        sb.append("**");
        last(n,i+1,sb);


    }
}


//    public static void rec(int n,int i)
//    {
//        if(n==i)
//            return;
//
//        for(int s=n-1;s>i-1;s--)
//                System.out.print(" ");
//            for(int j=0;j<2*i-1;j++)
//                System.out.print("*");
//            System.out.println();
//        rec(n,i+1);
//    }
//    public static void rec2(int n,int i,int j,int s)
//    {
//        if(j>=2*i-1)
//            return;
//        if(s==0) {
//            System.out.print("*");
//            j++;
//        }
//        else {
//            System.out.print(" ");
//            s--;
//        }
//        rec2(n,i,j,s);
//
//    }
//
//
//




