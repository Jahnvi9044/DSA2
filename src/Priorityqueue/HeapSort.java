package Priorityqueue;

import java.util.*;
//using min heap
public class HeapSort {

    public static void inplaceHeapSort(int[] arr)
    {
          int n=arr.length;
          int hs=0;
        for(int i=0;i<n;i++)
        {   hs++;
            //System.out.println(arr[i]);
            insert(i,arr,hs);
        }


        while(hs>0)
        {
            remove(arr,hs);
            hs--;
//            System.out.println("removal");
//            for(int i:arr)
//                System.out.print(i+" ");
        }
        for(int i:arr)
            System.out.print(i+" ");

    }

    public static void remove(int[] arr,int hs)
    {
        //Swap last index with the first index and then Heapify

        int temp=arr[0];
        arr[0]=arr[hs-1];
        arr[hs-1]=temp;
        hs--;
//        System.out.println(">>"+arr[0]+" "+arr[hs-1]);
        int parentIndex=0;
        int minIndex=parentIndex;
        int leftIndex=1;
        int rightIndex=2;
//        System.out.println("before heapify");
//        for(int i:arr)
//            System.out.print(i+" ");
        while(leftIndex<hs)
        {
            if(arr[leftIndex]<arr[minIndex])
                minIndex=leftIndex;
            if(rightIndex<hs && arr[rightIndex]<arr[minIndex])
                minIndex=rightIndex;
            if(parentIndex==minIndex)
                break;
            else
            {
                //swap parentIndex and minIndex;

                int temp1=arr[minIndex];
                arr[minIndex]=arr[parentIndex];
                arr[parentIndex]=temp1;

                parentIndex=minIndex;
                leftIndex=parentIndex*2+1;
                rightIndex=parentIndex*2+2;

            }
//            System.out.println();
//            System.out.print("after heapify==");
//            for(int i:arr)
//                System.out.print(i+" ");
//            System.out.println();
        }
        return ;

    }

    public static void insert(int i,int [] arr,int hs)
    {   int childI=i;//2,14,5,6,7,9};
        int parentI=(childI-1)/2;
//        System.out.println("..>>"+arr[childI]+" "+arr[parentI]);
        while(childI>0)
        {
//            System.out.println(childI+" "+parentI);
            if(arr[childI]<arr[parentI])
            {
                int temp=arr[childI];
                arr[childI]=arr[parentI];
                arr[parentI]=temp;

                childI=parentI;
                parentI=(childI-1)/2;
            }
            else return ;

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
           int [] arr={2,41,5,6,7,9};
           inplaceHeapSort(arr);
        }

    }
}
