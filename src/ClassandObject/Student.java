package ClassandObject;


public class Student {

    String name;
    private  int rollno;
     static int onRoll;

//    Student(String st,int no)
//    {   name=st;
//        rollno=no;
//    }
    Student(String k)
    {  rollno=9;
        name=k;
        onRoll++;
    }

    int getRollno()
    {
        return rollno;
    }
    void setRollno(int no)
    {
        rollno=no;
    }
}
