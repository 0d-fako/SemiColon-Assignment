package classTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MissingNumberListTest {
    private MissingNumberList list;

    @BeforeEach
    public void setUp() {
        list = new MissingNumberList();
    }


    @Test
    public void MissingNumberListWorksTest() {
        int[] numbersArray1 = {1, 2, 5};

        ArrayList<Integer> result = list.missingNumberList(numbersArray1);

        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(3, 4));
        assertEquals(result, output);




    }


}
