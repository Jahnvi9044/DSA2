package Priorityqueue;

import java.util.*;

public class kSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
          int[] arr= {2,4,5,9,8,6,1,10,12};
          int k=3;
          int i=0;
          for(i=0;i<k;i++)
          {pq.add(arr[i]);

          }
          for(;i<arr.length;i++)
          {
              arr[i-k]=pq.remove();
              pq.add(arr[i]);
          }
          for(;k>0;k--)
          {
              arr[i-k]=pq.remove();

          }
          for(int l:arr)
              System.out.print(l+" ");

        }

    }

