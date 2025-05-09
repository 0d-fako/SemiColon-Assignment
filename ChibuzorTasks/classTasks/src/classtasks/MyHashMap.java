package classtasks;

import java.util.*;

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


        List<Integer> nums = new ArrayList<Integer>();

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);

        Collections.sort(nums);

        System.out.println(nums);




    }
}
