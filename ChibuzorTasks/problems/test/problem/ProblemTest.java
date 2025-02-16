package problem;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problems.src.problem.Problem;

import static org.junit.jupiter.api.Assertions.*;


public class ProblemTest {
    private Problem problem;

    @BeforeEach
    public void setUp() {
        problem = new Problem( "Money", "Financial");
    }


    @Test
    public void problemCreatedTest() {
        assertEquals( "Money", problem.getName() );
    }

    @Test
    public void GetProblemNameTest() {
        assertEquals( "Money", problem.getName() );
    }

    @Test
    public void getProblemTypeTest() {
        assertEquals( "Financial", problem.getType() );
    }

    @Test
    public void getProblemStatusTest() {
        assertFalse(problem.getStatus());
    }

    @Test
    public void solveProblemTest() {
        problem.solveProblem();
        assertTrue(problem.getStatus());
    }
}
