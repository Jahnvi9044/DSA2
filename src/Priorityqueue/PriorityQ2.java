package Priorityqueue;

import java.util.*;

/**
 * Using Comparator
 *
 */
public class PriorityQ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int  [] arr={12,4,3,5,8,19};
        System.out.print("Ascending order :");
       minPQComparator minComparator=new minPQComparator();
       PriorityQueue<Integer> minPQ=new PriorityQueue<>(minComparator);
       for(int i:arr)
           minPQ.add(i);
       while(!minPQ.isEmpty())
           System.out.print(minPQ.remove()+" ");


        System.out.println();
        System.out.print("Descending Order :");
        maxPQComparator maxComparator=new maxPQComparator();
        PriorityQueue<Integer> maxPQ=new PriorityQueue<>(maxComparator);
        for(int i:arr)
            maxPQ.add(i);
        while(!maxPQ.isEmpty())
            System.out.print(maxPQ.remove()+" ");
    }


}
class minPQComparator implements Comparator<Integer>
{


    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1<o2)
        return -1;
        else if (o1>o2)
            return 1;
        else return 0;
    }
}
class maxPQComparator implements Comparator<Integer>
{


    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1<o2)
            return 1;
        else if (o1>o2)
            return -1;
        else return 0;
    }
}