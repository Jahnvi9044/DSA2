package Recursion;

import java.util.*;

public class ConmSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr={
                13, 3, 2, 17 };
        Arrays.sort(arr);
        System.out.println(combSum(arr,14));

    }


        public static List< List < Integer > > combSum(int []ARR, int B) {
            // Write your code here.

            List<List< Integer >> arr= new ArrayList<>();
            combSum(ARR, 0, B, arr, ARR.length, new ArrayList<>());
            return arr;
        }

        public static void combSum(int []ARR,int i, int target, List<List< Integer >>  arr,int n,ArrayList<Integer> lis) {



            if(target==0)
            {
                arr.add(new ArrayList<>(lis));
                return ;
            }
            if(i>=n)
            {
                if(target==0)
                {    if(!arr.contains(lis))
                    arr.add(new ArrayList<>(lis));
                }

                return ;

            }


            //take

            if(target-ARR[i]>=0)
            {lis.add(ARR[i]);
            combSum(ARR, i, target-ARR[i], arr, n, lis);
            lis.remove(lis.size()-1);}
            combSum(ARR, i+1, target, arr, n, lis);






        }
    }



