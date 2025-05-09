package classtasks;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {

    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<String, Integer>();
        students.put("Kevin", 23);
        students.put("John", 22);
        students.put("Michael", 21);
        System.out.println(students);


        System.out.println(students.keySet());


        for (String name : students.keySet()) {
            System.out.println(name);
        }

    }
}
