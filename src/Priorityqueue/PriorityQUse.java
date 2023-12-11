package Priorityqueue;

import java.util.*;

public class PriorityQUse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQ1 ob=new PriorityQ1();
      int[] arr={5,9,2,1,0};
      for(int i=0;i<arr.length;i++)
      {
          ob.insert(arr[i]);
      }
      while(!ob.isEmpty())
      {
          System.out.print(ob.remove()+" ");
      }
        System.out.println("this is the sorted array ");

    }
}
