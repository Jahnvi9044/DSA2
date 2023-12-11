package Priorityqueue;

import java.util.*;

public class RunningMedian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int arr[]={5 ,4 ,3, 2 ,1};
            findMedian(arr);

        }

    }


        public static void findMedian(int arr[])  {

        PriorityQueue<Integer> pq =new PriorityQueue<>();

        for(int i=0;i< arr.length;i++)
        {  int [] arr1=new int[i+1];
            int k=0;
            pq.add(arr[i]);
            while(!pq.isEmpty())
            {
                arr1[k] = pq.poll();
                k++;
            }
            if((k&1)==1)


                System.out.print(arr1[k/2]+" ");
            else if((k&1)==0)
                System.out.print((arr1[k/2]+arr1[k/2-1])/2+" ");
            for(int j=0;j< arr1.length;j++) {
                pq.add(arr1[j]);
            }

        }
        }



}
