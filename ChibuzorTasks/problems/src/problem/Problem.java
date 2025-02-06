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
}
