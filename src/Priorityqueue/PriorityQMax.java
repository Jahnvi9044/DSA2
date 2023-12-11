package Priorityqueue;

import java.util.*;

public class PriorityQMax {
      private static ArrayList<Integer> heap;
      public PriorityQMax()
      {
          heap=new ArrayList<>();
      }

        boolean isEmpty() {
            return heap.size()==0;
        }

        int getSize() {
           return heap.size();
        }

        int getMax() {
          return heap.get(0);
        }

        void insert(int element) {
           heap.add(element);
           //now heapify
            int childIndex=heap.size()-1;
            int parentIndex=(childIndex-1)/2;

            while(childIndex>0)
            {  if(heap.get(parentIndex)< heap.get(childIndex))
               {
                   int temp=heap.get(parentIndex);
                   heap.set(parentIndex,heap.get(childIndex));
                   heap.set(childIndex,temp);

                   childIndex=parentIndex;
                   parentIndex=(childIndex-1)/2;

               }
                else return ;
            }
        }

        int removeMax() {
           int temp=heap.get(0);
           heap.set(0,heap.get(heap.size()-1));
           heap.set(heap.size()-1,temp);
           heap.remove(heap.size()-1);
           int parentIndex=0;
           int maxindex=parentIndex;
           int leftIndex=1;
           int rightIndex=2;

           while(leftIndex<heap.size()) {
               if (heap.get(leftIndex) > heap.get(maxindex))
                   maxindex = leftIndex;
               if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxindex))
                   maxindex = rightIndex;
               if (parentIndex == maxindex)
                   break;
               else {
                   int temp1 = heap.get(maxindex);
                   heap.set(maxindex, heap.get(parentIndex));
                   heap.set(parentIndex, temp1);

                   parentIndex = maxindex;
                   leftIndex = 2 * parentIndex + 1;
                   rightIndex = 2 * parentIndex + 2;
//                   System.out.println(heap);
               }
           }




           return temp;
        }

    public static void main(String[] args) {
        PriorityQMax ob=new PriorityQMax();
        int[] arr={10,20,40,60,8};
        for(int i=0;i<arr.length;i++)
          ob.insert(arr[i]);
        System.out.println(heap);
        while(!ob.isEmpty())
            System.out.print(ob.removeMax()+" ");

    }
    }

