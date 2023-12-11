package ClassandObject;

import java.util.*;

public class Polynomial {
   ArrayList<Integer> eq;
   Polynomial()
   {
      eq=new ArrayList<>();
   }
   void setcoeffecient(int deg,int co) {
      if(deg>eq.size())
      {
         for(int i=0;i<deg+1;i++)
            eq.add(0);
      }
      eq.set(deg,co);

   }
   void print()
   {
       System.out.println(eq);

       boolean bool=false;
      for(int i=eq.size()-1;i>=0;i--)
     {  if(eq.get(i)!=0)
      {  if(bool==true)
        System.out.print(" + ");
        if(i==0)
           System.out.print(eq.get(0));
        else
         System.out.print(eq.get(i)+"x^"+i);
        bool=true;
      }
     }
      System.out.println();
    }
    private int getsize(Polynomial p2)
    {
        return p2.eq.size();
    }
   void add(Polynomial p2)
   {      Polynomial p3=new Polynomial();
          int s=eq.size();
          if(getsize(p2)>eq.size())
              s=getsize(p2);
          for(int i=0;i<s;i++)
          {
            p3.eq.add(0);
          }
      int i=0,j=0,k=0;
         while(i<eq.size()&&j<getsize(p2))
         {
             p3.setcoeffecient(k,eq.get(i)+p2.eq.get(j));
             i++;j++;k++;
         }
         while(i<eq.size())
         {
             p3.setcoeffecient(k,eq.get(i));
             i++;
             k++;
         }
         while(j<getsize(p2))
         {
             p3.setcoeffecient(k,p2.eq.get(j));
             j++;
             k++;
         }
         this.eq=p3.eq;
   }
   void subtract(Polynomial p2)
   {
       int s=getsize(p2);

       if(eq.size()<getsize(p2))
           s=eq.size();
       for(int i=0;i<s;i++)
       {
           eq.set(i,eq.get(i)-p2.eq.get(i));
       }
   }
   void multiply(Polynomial p2)
   {   Polynomial p3=new Polynomial();
       int k=getsize(p2)*eq.size();
       for(int i=0;i<k;i++)
       {
           p3.eq.add(0);
       }
       k=0;
       for(int i=0;i<getsize(p2);i++)
       {   for(int j=0;j<eq.size();j++)
          {   int d=i*j;
              int c=p2.eq.get(i)*eq.get(j);

              p3.setcoeffecient(d,c);
          }
       }
       System.out.println(p3.eq);


   }
   int evaluate(int x)
   {
       int ans =0;
       for(int i=0;i<eq.size();i++)
        ans=ans+(int)Math.pow(x,i)*eq.get(i);


       return ans;
   }
   static Polynomial add(Polynomial p1,Polynomial p2)
    {   int s=p2.eq.size();

        if(p1.eq.size()>p2.eq.size())
            s=p1.eq.size();
        Polynomial p3=new Polynomial();
        for(int i=0;i<s;i++)
        {
            p3.setcoeffecient(i,p1.eq.get(i)+p2.eq.get(i));
        }
         return p3;

    }

}
