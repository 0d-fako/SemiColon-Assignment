package classtasks;

import java.util.*;

public class MyHashMap {

    public static void main(String[] args) {

        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1%10 > o2%10)
                    return 1;
                else
                    return -1;
            }
        };


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

        nums.add(18);
        nums.add(26);
        nums.add(31);
        nums.add(45);

        nums.sort(com);

        System.out.println(nums);




    }
}
