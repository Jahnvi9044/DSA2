package ClassandObject;

import java.util.*;

public class PolynomialUse {
    public static void main(String[] args) {
        Polynomial p1=new Polynomial();
        p1.setcoeffecient(2,2);
        p1.setcoeffecient(0,4);
        p1.print();

        Polynomial p2=new Polynomial();
        p2.setcoeffecient(3,20);
        p2.setcoeffecient(2,40);
        p2.setcoeffecient(1,10);
        p2.print();
        System.out.println("addition");
        p1.add(p2);
        p1.print();
        p2.print();
        System.out.println("subtraction ");
        p1.subtract(p2);
        p1.print();
        p2.print();
//
        System.out.println("multiplication");
        p1.multiply(p2);
        p1.print();
        p2.print();
//
//        p1.evaluate(10);
//        p1.print();
//        p2.print();
//
//        Polynomial p3= Polynomial.add(p1,p2);
//        p3.print();
//        p1.print();
//        p2.print();
//
//    }
}}
