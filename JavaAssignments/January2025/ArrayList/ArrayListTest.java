package January2025.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {


    @Test
    public void testAdd() {
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        assertEquals(3, list.size());
    }
}
