package mydairy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DairyTest {
    private Dairy dairy;

    @BeforeEach
    public void setUp() {
        dairy = new Dairy("fullname", "pin");
    }


    @Test
    public void lockDairy_testDairy() {
        dairy.lock();
        assertTrue(dairy.isLocked());
    }

    @Test
    public void unlockDairy_testDairy() {
        dairy.unlock("pin");
        assertFalse(dairy.isLocked());
    }


    @Test
    public void unlockDairyWithIncorrectPIn_testDairy() {
        assertThrows(IllegalArgumentException.class, () -> dairy.unlock("pin123"));
    }

    @Test
    public void unlockDairyWithNullPin_testDairy() {
        assertThrows(NullPointerException.class, () -> dairy.unlock(null));
    }

    @Test
    public void testToGetDairyUsername_whenLocked_testDairy() {
        dairy.lock();
        assertThrows(IllegalAccessError.class, () -> dairy.getUsername());
        dairy.unlock("pin");
        assertEquals("fullname", dairy.getUsername());
    }

}
