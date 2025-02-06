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

    public String getName() {
        return name;
    }

    public ArrayList<Problem> getProblems() {
        return problems;
    }

    public int getNoOfProblems() {
        return noOfProblems;
    }

    public void addProblem(String name, String type) {
        problems.add(new Problem(name, type));
        noOfProblems++;
    }


}
