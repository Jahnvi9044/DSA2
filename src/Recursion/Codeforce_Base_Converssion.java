package Recursion;

import java.math.BigInteger;
import java.util.*;

public class Codeforce_Base_Converssion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
            int n=sc.nextInt();
            BigInteger bg=new BigInteger(String.valueOf(n));
            dec_to_bin(bg,new BigInteger("0"),new BigInteger("1"),new BigInteger("2"),new BigInteger("10"));
        }

    }

    public static void dec_to_bin(BigInteger n,BigInteger ans,BigInteger i,BigInteger t2,BigInteger t10)
    {  if(n.equals(new BigInteger("0")))
    {System.out.println(ans);
        return ;}
        ans=ans.add(n.mod(t2).multiply(i));

        i=i.multiply(t10);
        n=n.divide(t2);
        dec_to_bin(n,ans,i,t2,t10);

    }
}
