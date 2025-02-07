package problem;

public class Problem {
    private String name;
    private String type;
    private boolean isSolved;


    public Problem(String name, String type) {
        this.name = name;
        this.type = type;
        this.isSolved = false;
    }

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return isSolved;
    }

    public String getType() {
        return type;
    }

    public void solveProblem() {
        isSolved = true;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Problem problem) {
            return this.name.equals(problem.name) && this.type.equals(problem.type);
        }
        return false;
    }
}
