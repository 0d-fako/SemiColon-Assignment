package classtasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student> {

    int age;
    String name;


    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }



    public static void main(String[] args) {


        Comparator<Student> comparator =  (Student s1, Student s2) ->  s1.age > s2.age?1:-1;


        List<Student> students = new ArrayList<Student>();

        students.add(new Student(18, "James"));
        students.add(new Student(24, "Bob"));
        students.add(new Student(25, "John"));


        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println(students);

        Collections.sort(students, comparator);



    }

    @Override
    public int compareTo(Student that) {
        if(this.age > that.age){
            return 1;
        }
        return 0;
    }
}
