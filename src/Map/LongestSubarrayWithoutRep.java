package Map;

import java.util.*;

public class LongestSubarrayWithoutRep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {//Write your code here

            String st=sc.nextLine();
            int n=st.length();

            System.out.println( LongestSubarray(st,n));
        }
    }

    public static int LongestSubarray(String st,int n) {
         int l=0,i,len=0;
         HashMap<Character,Integer> map=new HashMap<>();
         for( i=0;i<n;i++)
         {
             char ch=st.charAt(i);
             if(map.containsKey(ch)&& l<=map.get(ch))
             {   int tempL=(i-1)-l+1;
                 if(tempL>len)
                     len=tempL;
                 System.out.println(l+" "+i+" "+tempL);
                 int k=map.get(ch);
                 l=k+1;
                 map.put(ch,i);
                 System.out.println(l+" "+i+" "+tempL);
                 System.out.println();


             }
             else if(map.containsKey(ch))
             {
                 map.put(ch,i);
                 System.out.println(ch+" i="+i);
                 System.out.println();

             }
             else if(!map.containsKey(ch))
             {   map.put(ch,i);
                 System.out.println(ch+" i="+i);
                 System.out.println();
                // r++;

             }

         }
        int tempL=(i-1)-l+1;
        if(tempL>len)
            len=tempL;
        System.out.println(tempL);
        System.out.println(map);
        return len;

    }
}
/**
 * try this input
 * aabaab!bb
 *
 */