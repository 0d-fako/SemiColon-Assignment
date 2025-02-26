package classtasks;

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
    public void MissingNumberListWorksForSortedArrayTest() {
        int[] numbersArray = {1, 2, 5,7,9};
        ArrayList<Integer> result = list.missingNumberList(numbersArray);
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(3, 4, 6, 8));
        assertEquals(result, output);


    }


    @Test
    public void missingNumberListWorksForUnsortedArrayTest() {
        int[] numbersArray = {5, 1, 2};
        ArrayList<Integer> result = list.missingNumberList(numbersArray);
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(3, 4));
        assertEquals(result, output);
    }


}

