package ClassandObject;

import java.util.*;

public class StudentUse {
    public static void main(String[] args) {
        Student s1=new Student("kunal");

        System.out.println(s1.name+":"+s1.getRollno());
        s1.setRollno(20);
        System.out.println(s1.name+":"+s1.getRollno());
        Student s2=new Student("kuro");
        Student s3=new Student("kumal");
        System.out.println(s2.onRoll);
        System.out.println(s3.onRoll);
        System.out.println(Student.onRoll);
    }
}
