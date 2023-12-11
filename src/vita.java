
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.*;


public class vita {


    public static void main(String[] args) {

        try {
            input();
        }
        catch(Exception e) {
            System.out.println("Invalid");
        }

    }

    public static void input(){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
        {
            BigDecimal b1=sc.nextBigDecimal();
            String st=sc.nextLine().substring(1);
            String ans=s1(b1,st);
            System.out.println(ans);


        }


    }


    public static String  s1(BigDecimal bi,String st) {



        // Convert to scientific notation using invariant Locale.ROOT
        NumberFormat formatter = new DecimalFormat("0.######E0", DecimalFormatSymbols.getInstance(Locale.ROOT));
        String str = formatter.format(bi);

        System.out.println(bi);
        System.out.println();
        System.out.println(str);


       int sign=bi.compareTo(new BigDecimal(0));
       String si="-";
       if(sign==1)
           si="+";

        String s1=str.substring(2);
        String[] sArr= s1.split("E");
        System.out.println("s1= "+s1+" s2= "+sArr[0]+ " "+sArr[1]);
        String s2=sArr[0];
//        needed
        BigInteger s2toDig= s2ToDig(new BigInteger(s2));
        String s3=sArr[1];
        if(s3.charAt(0)=='-')
            s3=s3.substring(1);
        BigInteger s3toDig=s2ToDig(new BigInteger(s3));

        String no=str.substring(0,1);
        System.out.println("no= "+no+" s3toDig = "+s3toDig+"  s2todig "+s2toDig);
//        Ab mujhe chahiye inke age ka part
        String A_no=Helper(new BigInteger(no));
        String A_s2=Helper(s2toDig.subtract(new BigInteger("1")));
        String A_s3=Helper(s3toDig);

        String ans=A_no+"."+A_s2+"e"+si+A_s3;
        System.out.println("ans = "+ans);

        BigDecimal bd = new BigDecimal(s2);
//        BigDecimal bd = new BigDecimal(s2);
        BigInteger output = bd.toBigInteger();

        System.out.println();
        System.out.println(output);





//         WORKING ON ST
        Integer n=s3toDig.intValue();
        int i=0;
        if(n%2==(0))
            i=1;
        System.out.println("i"+i);
        char[] ch=st.toCharArray();
        String ans2="";
        for( int j=i;j<ch.length;j+=2)
        {
            ans2+=ch[j];

        }





        return ans+"@"+ans2;
    }

    public static String Helper(BigInteger b1) {
        if(b1.equals(new BigInteger("0")))
            return "zer";
        if(b1.equals(new BigInteger("1")))
            return "one";
        if(b1.equals(new BigInteger("2")))
            return "two";
        if(b1.equals(new BigInteger("3")))
            return "thr";
        if(b1.equals(new BigInteger("4")))
            return "fou";
        if(b1.equals(new BigInteger("5")))
            return "fiv";
        if(b1.equals(new BigInteger("6")))
            return "six";
        if(b1.equals(new BigInteger("7")))
            return "sev";
        if(b1.equals(new BigInteger("8")))
            return "eig";
        if(b1.equals(new BigInteger("9")))
            return "nin";
        return "jj";
    }
    public static BigInteger s2ToDig(BigInteger bi) {

       return  digSum(bi,new BigInteger("9"));

    }
    static BigInteger digSum(BigInteger n,BigInteger n9)
    {  return   (n.subtract(new BigInteger("1"))).mod( new BigInteger("9")).add(new BigInteger("1"));

    }
}
