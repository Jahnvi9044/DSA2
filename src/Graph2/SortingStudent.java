package Graph2;

import java.lang.reflect.Array;
import java.util.*;

public class SortingStudent {

    public static void main(String[] args) {
//         Student s1=new Student(23,"Sunakshi");
//         Student s2=new Student(25,"Rohit");
//         Student s3=new Student(45,"Nishi");
//         Student s4=new Student(19,"Pariniti");

        List<Student> stud= Arrays.asList(new Student(23,"Sunakshi"),new Student(25,"Rohit")
        ,new Student(45,"Nishi"),new Student(19,"Pariniti"));
//                new ArrayList<>();
//        stud.add(new Student(23,"Sunakshi"));
//        stud.add(new Student(25,"Rohit"));
//        stud.add(new Student(45,"Nishi"));
//        stud.add(new Student(19,"Pariniti"));

//One Liner Code
         Comparator<Student> ob= ( o1,o2)-> (o1.age>o2.age)?1:-1;



/**
 * One way
 */
//        Comparator<Student> ob= new Comparator<Student>() {
//
//            @Override
//            public int compare(Student o1, Student o2) {
//
//
//                if(o1.age>o2.age)
//                    return 1;//1 means if this is the case then swap
//                else return -1;
//
//            }
//        };

     ///Write this
        Collections.sort(stud,ob);
        System.out.println(stud);


     //Or write this
       Collections.sort(stud);





        System.out.println(stud);



    }
}
///DIFFERENCE BETWEEN CAOMPARTOR  AND COMPAREABLE
/**
       Comparator gives you the chance to the third party to compare between 2 things
       IT IS A FUNCTIONAL INTERFACE
        WHICH MEANS CAN BE WRITTEN IN LAMBDA Expression
        Whereas
        Comparable gives the chance to one of the 2 things itself to compare and swap
          between him and other person

 */