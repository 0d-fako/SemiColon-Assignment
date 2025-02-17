package January2025.Sets;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MySetTest {
    private MySet mySet;

    @BeforeEach
    public void setUp() {
        mySet = new MySet();
    }

    @Test
    public void testAdd() {
        mySet.add(1);
        assertTrue(mySet.contains(1));
        assertEquals(1, mySet.size());

        mySet.add(1);
        assertEquals(1, mySet.size());
    }

    @Test
    public void testRemove() {
        mySet.add(1);
        mySet.add(2);
        mySet.remove(1);
        assertFalse(mySet.contains(1));
        assertEquals(1, mySet.size());
    }

    @Test
    public void testContains() {
        mySet.add(1);
        assertTrue(mySet.contains(1));
        assertFalse(mySet.contains(2));
    }

    @Test
    public void testSize() {
        assertEquals(0, mySet.size());
        mySet.add(1);
        assertEquals(1, mySet.size());
    }

    @Test
    public void testClear() {
        mySet.add(1);
        mySet.add(2);
        mySet.clear();
        assertEquals(0, mySet.size());
        assertFalse(mySet.contains(1));
        assertFalse(mySet.contains(2));
    }

    @Test
    public void testToString() {
        mySet.add(1);
        mySet.add(2);
        assertEquals("MySet { 1, 2 }", mySet.toString());
    }
}
