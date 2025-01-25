package January2025.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private ArrayList list;

    @BeforeEach
    public void initialize() {
        list = new ArrayList();
    }


    @Test
    public void testThatListIsEmpty() {
       assertTrue(list.isEmpty());

    }

    @Test
    public void testThatListIsNotEmpty() {
        list.add("Benz");
        assertFalse(list.isEmpty());

    }

    @Test
    public void testListGetSize(){
        list.add("Volvo");
        list.add("Audi");
        assertEquals(2, list.size());
    }


    @Test
    public void testAdd() {
        list.add("1");
        list.add("2");
        list.add("3");
        assertEquals(3, list.size());
    }
}
