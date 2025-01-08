package TestDrivenDevelopment.arraySearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArraySearchTest {

    @Test
    public void testArraySearch() {

        //Given
        ArraySearch arraySearch = new ArraySearch();
        int[] myList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int number = 6;

        //Action
        int result = arraySearch.array_search(myList, number);

        //Check
        assertEquals(5, result);

    }
    @Test
    public void testArraySearchForNonAvailable() {

        //Given
        ArraySearch arraySearch = new ArraySearch();
        int[] myList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int number = 3;

        //Action
        int result = arraySearch.array_search(myList, number);

        //Check
        assertEquals(2, result);

    }
}
