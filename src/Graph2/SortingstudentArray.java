package Graph2;

import java.util.*;

public class SortingstudentArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] stud={new Student(23,"Sunakshi"),new Student(25,"Rohit")
                ,new Student(45,"Nishi"),new Student(19,"Pariniti")};

        Comparator<Student> stu=(o1,o2)->o1.age>o2.age?-1:1;

        Arrays.sort(stud,stu);

        Arrays.sort(stud);
        for(Student s:stud)
        System.out.println(s);



    }
}
