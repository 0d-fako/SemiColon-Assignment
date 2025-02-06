package problem;

import java.util.ArrayList;

public class Person {
    private String name;
    private ArrayList<Problem> problems;
    private int noOfProblems;


    public Person(String name) {
        this.name = name;
        this.problems = new ArrayList<>();
        this.noOfProblems = 0;
    }
}
