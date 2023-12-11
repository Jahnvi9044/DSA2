package Priorityqueue;

import java.util.*;

public class PriorityQ3 {
    public static void main(String[] args) {
        pqComparator  ob=new pqComparator();
        PriorityQueue<String> pq=new PriorityQueue<>(ob);
        String[] arr={"Hey1 "," you2 ","there3" ," how4 "," are5", " you6"};
        for(String i:arr) pq.add(i);
        while(!pq.isEmpty())
            System.out.print(pq.remove()+" ");


        //
        System.out.println();

        pqComparator2  ob1=new pqComparator2();
        PriorityQueue<String> pq2=new PriorityQueue<>(ob1);
        String[] arr1={"Hey1 "," you2 ","there3" ," how4 "," are5", " you6"};
        for(String i:arr1) pq2.add(i);
        while(!pq2.isEmpty())
            System.out.print(pq2.remove()+" ");


    }
}


class pqComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() < o2.length()) return -1;
        else if (o1.length() > o2.length()) return 1;
        return 0;
    }
}
class pqComparator2 implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() < o2.length()) return 1;
        else if (o1.length() > o2.length()) return -1;
        else if (o1.length()==o2.length())return -1;
        else return 0;
    }
}