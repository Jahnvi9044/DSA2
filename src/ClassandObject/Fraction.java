package ClassandObject;

import java.util.*;

public class Fraction {

    private  int nu;
     private int de;
     Fraction(int nu,int de) throws ZeroDenominatorException
     {

         if(de==0)
             throw new ZeroDenominatorException();
         this.nu=nu;
         this.de=de;
         simplify();
     }

     void setNu(int nu)
     {   this.nu=nu;
         simplify();
     }
     void setDe(int de)
     {this.de=de;
         simplify();
     }
     int getNu()
     {
         return nu;
     }
     int getDe()
     {
         return de;
     }
     void print()
     {
         if(de==1)
         System.out.println(nu);
         else
             System.out.println(nu+"/"+de);

     }
     private void simplify()
     {   int d=gcd(nu,de);
         nu=nu/d;
         de=de/d;

     }
     private int  gcd(int divident,int divisor)
     {   if(divisor==0)
         return divident;
         return gcd(divisor,divident%divisor);
     }

     void add(Fraction f2)
     {   nu=nu*f2.de+de*f2.nu;
         de=de*f2.de;
//         System.out.println("de="+de);
//         System.out.println("nu="+nu);

         simplify();
     }

     void multiply(Fraction f3)
     {
         de=de*f3.de;
         nu=nu*f3.nu;
         simplify();
     }

     static Fraction add(Fraction f1,Fraction f2) throws ZeroDenominatorException
     {

         int n=f1.nu*f2.de+f1.de*f2.nu;
         int d=f1.de*f2.de;

         return new Fraction(n,d);
     }

}
