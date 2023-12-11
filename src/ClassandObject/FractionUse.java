package ClassandObject;

import java.util.*;

public class FractionUse {
    public static void main(String[] args) throws ZeroDenominatorException {


        Fraction f1=new Fraction(20,0);
        f1.print();//  2/3
        f1.setNu(12);//  12/3
        f1.print();// 4

        Fraction f2=new Fraction(6,8);
        f1.add(f2);
        f1.print();
        f2.print();

        Fraction f3=new Fraction(12,20);
        f1.multiply(f3);
        f1.print(); //  3/5
        f2.print();

        Fraction f4=Fraction.add(f1,f2);
        f4.print();

    }
}
