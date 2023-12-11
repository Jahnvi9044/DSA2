package DynamicProgramming;

import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long startTime=System.currentTimeMillis();
        System.out.print(fibo(40)+" Time taken:");
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);



        //Memoization
         startTime=System.currentTimeMillis();
        System.out.print(fiboM(40)+" Time taken:");
        endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    //Recursion Time Complexity=O(2^n) //Exponential
    public static int fibo(int n){
        if(n==1||n==0)
            return n;
        return fibo(n-1)+fibo(n-2);
    }

    //Memoization  Time Complexity=O(n) //Linear

    public static int fiboM(int n)
    {
        int[] arr=new int[n+1];

        for(int i=0;i<n+1;i++)
            arr[i]=-1;

        return fiboM(n,arr);
    }
    public static int fiboM(int n,int[] arr)
    {
        if(n==1||n==0)
            return n;
        if(arr[n]!=-1)
            return arr[n];
        arr[n]=fiboM(n-1,arr)+fiboM(n-2,arr);
        return arr[n];

    }
}
