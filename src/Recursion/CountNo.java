package Recursion;

import java.util.*;

public class CountNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
             String st =sc.next();
            System.out.println(countandsay(st));
        }

    }

    public static String countandsay(String st)
    {

        int count=1;
        String ans="";
        for(int i=0;i<st.length()-1;i++)
        {
            char ch=st.charAt(i);
            char ch2=st.charAt(i+1);
            if(ch==ch2)
                count++;

            else{
                ans=ans+count+ch;
                count=1;
            }

        }

            ans=ans+count+st.charAt(st.length()-1);

       return ans;
    }

    }


