package Map;
import java.util.*;
public class consecutiveSequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        System.out.println( longestConsecutiveIncreasingSequence(arr));
    }
        public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
            HashMap<Integer,Boolean > map=new HashMap<>();
            int max_Len=0;
            int len=0;
            int start=0;
            int end=0;
            for(int i=0;i<arr.length;i++)
            {
                if(!map.containsKey(arr[i]))
                {
                    map.put(arr[i],false);
                }
            }

            for(int i=0;i<arr.length;i++)
            {
                if(map.containsKey(arr[i]-1)&&!map.get(arr[i]-1))
                    map.put(arr[i]-1,true);
            }
            //   System.out.println(map);
            for(int i=0;i<arr.length;i++)
            {   len=0;

                int no=arr[i];
                int s=no,e=no;
                if(map.get(arr[i]))
                {s=arr[i];

                    while(map.containsKey(no))
                    {
                        len++;
                        //  System.out.println(no+" 1");
                        e=no;
                        no++;
                    }
                    if(len>max_Len)
                    {
                        max_Len=len;
                        start=s;
                        end=e;
                    }
                }}
            ArrayList<Integer> ans=new ArrayList<>();
            ans.add(start);
            if(start!=end)
            {

                ans.add(end);
            }
            return ans;
        }
}
/**
 * In this question you have to find the consecutive increasing sequence
 */

/**INPUT:
 * 7
 * 3 7 2 1 9 8 41
 * OUTPUT:[7, 9]
 */

/**INPUT:
 * 13
 * 2 12 9 16 10 5 3 20 25 11 1 8 6
 * OUTPUT:[8, 12]
 */
