package problems.src.problem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {
    private Person person;


    @BeforeEach
    public void setUp() {
        person = new Person("Ayo");

    }

    @Test
    public void personCreatedSuccessfullyTest() {
        assertEquals("Ayo", person.getName());
    }

    @Test
    public void newlyCreatedPersonHasZeroProblemsTest() {
        assertEquals(0, person.getProblems().size());
    }

    @Test
    public void newlyCreatedPersonCanAddProblemsTest() {
        person.addProblem("Name", "Type");
        assertEquals(1, person.getProblems().size());
    }


    @Test
    public void PersonCanAddMultipleProblemsTest() {
        person.addProblem("Name", "Type");
        person.addProblem("Name", "DifferentType");
        assertEquals(2, person.getProblems().size());
    }

    @Test
    public void findProblemByStatusTest(){
        person.addProblem("Name", "Type");
        person.addProblem("Name", "DifferentType");
        person.findProblemByType("Type");


    }

}
