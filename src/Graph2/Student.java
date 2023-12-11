package Graph2;

import java.util.*;

public class Student implements Comparable<Student>{
    int age;
    String name;
    public Student(int age,String name)
    {   this.age=age;
        this.name=name;
    }
    public String toString()
    {
        return "Student ["+age+","+name+"]";
    }



    @Override
    public int compareTo(Student o) {
        if(this.name.length()>o.name.length())

            return 1;//1 means if this is the case then swap
        else return -1;
    }
}
