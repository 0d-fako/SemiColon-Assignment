package classTasks.test.classtasks;

import classTasks.src.classtasks.Multiples;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;

public class MultiplesTest {
    private Multiples multiples;



    @BeforeEach
    public void setUp() {
        multiples = new Multiples();
    }


    @Test
    public void multipleWorksCorrectlyTest() {
        int startingNumber = 5;
        int endingNumber = 50;
        int multiple = 5;

        ArrayList<Integer> result = multiples.multiples(startingNumber, endingNumber, multiple);
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40, 45, 50));
        Assertions.assertEquals(output, result);


    }

    @Test
    public void multipleArrayWorksCorrectlyTest() {
        int startingNumber = 5;
        int endingNumber = 50;
        int multiple = 5;

        int[] result = multiples.multiplesArray(startingNumber, endingNumber, multiple);
        int[] output = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
        Assertions.assertArrayEquals(output, result);


    }


}
