package Map;

import java.util.*;

public class SubArraySumK {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        //  int k=sc.nextInt();
        System.out.println(subArr(arr,arr.length,0));
    }

    public static int subArr(int[] arr,int n,int k)
    {   int sum=0;
        int start=0,end=-1;
        int max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        for(int i=0;i<n;i++)
        {sum=sum+arr[i];
            int temp=sum-k;

            if(!map.containsKey(sum))
                map.put(sum,i+1);

            if(map.containsKey(temp))
            {     if(max<i+1-map.get(temp))
                      max=i+1-map.get(temp);
            }

        }
        return max;
    }
}
