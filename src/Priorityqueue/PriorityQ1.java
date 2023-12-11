package Priorityqueue;

import java.util.*;

public class PriorityQ1 {

   private static ArrayList<Integer> heap;

    public PriorityQ1()
    {
        heap=new ArrayList<>();
    }
    public boolean isEmpty()
    {
        return heap.size()==0;
    }
    public int size()
    {
        return heap.size();
    }
    public int getMin() throws PriorityQEmptyException
    {  /**
       *returns the root element
       */
        if(isEmpty())
            throw new PriorityQEmptyException();

        return heap.get(0);
    }

    public void insert(int element)
    {
        heap.add(element);
        int childIndex=heap.size()-1;
        int parentIndex=(childIndex-1)/2;
        while(childIndex>0)
        {
            if(heap.get(childIndex)<heap.get(parentIndex))
            {/**
             1) Swap parent element and child element
             2) Update parent and child Index
                */
            int temp=heap.get(childIndex);
            heap.set(childIndex,heap.get(parentIndex));
            heap.set(parentIndex,temp);

            childIndex=parentIndex;
            parentIndex=(childIndex-1)/2;

            }
            else return;
        }
    }

    public int remove() {
        /**
         * This function removes the root of the heap (top element)
         * O(log n) Time Complexity
         * 1). Swaps the last index with the root , then removes the last element
         * 2). After that heapify the heap
         */


        int temp = heap.get(0);
        heap.set(0, heap.get(size() - 1));
        heap.set(heap.size() - 1, temp);

        heap.remove(heap.size() - 1);
//        System.out.println(heap);
        int parentindex = 0;
        int minIndex=parentindex;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while(leftChildIndex < heap.size()){

            if(heap.get(leftChildIndex) < heap.get(minIndex)){
                minIndex = leftChildIndex;
            }
            if(rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)){
                minIndex = rightChildIndex;
            }
            if(minIndex == parentindex){
                break;
            }else{
                int temp1 = heap.get(parentindex);
                heap.set(parentindex, heap.get(minIndex));
                heap.set(minIndex, temp1);
                parentindex = minIndex;
                leftChildIndex = 2 * parentindex + 1;
                rightChildIndex = 2 * parentindex + 2;
            }
        }
        return temp;

    }




    public void swap(int a ,int b)
    {
        int temp=heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b,temp);
    }
//    public boolean leaf(int i)
//    {   int left=2*i+1;
//        int right=2*i+2;
//        if(left>heap.size()-1&&right>heap.size())
//            return true;
//        else return false ;
//    }
   public void print()
   {
       System.out.println(heap);
   }
    public static void main(String[] args) {
        PriorityQ1 ob=new PriorityQ1();

        ob.insert(5);
        ob.insert(10);
        ob.insert(8);
        ob.insert(15);
        ob.insert(20);
        ob.insert(35);
        ob.insert(4);
        ob.print();

        /**
         * output of the above code :::
         * [5, 10, 8, 15, 20, 35]
         * [5, 10, 8, 15, 20, 35]
         */
        ob.remove();
        ob.print();
        /**
         * op of the above code :::
         * [5, 10, 8, 15, 20, 35] -
         * [5, 10, 8, 15, 20, 35]
         */
    }
}
