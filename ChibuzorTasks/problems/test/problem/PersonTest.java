package problem;

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
}
