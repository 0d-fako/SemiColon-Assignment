package mydairy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DairyTest {
    private Dairy dairy;
    private static final String USERNAME = "testUser";
    private static final String INITIAL_PIN = "1234";

    @BeforeEach
    public void setUp() {
        dairy = new Dairy( USERNAME, INITIAL_PIN );
    }

    @Test
    public void newDairy_shouldBeUnlockedInitially() {
        assertFalse(dairy.isLocked());
    }

    @Test
    public void newDairy_hasCorrectName() {
        assertEquals(USERNAME, dairy.getName());
    }

    @Test
    public void validatePin_withCorrectPin_shouldReturnTrue() {
        assertTrue(dairy.validatePin(INITIAL_PIN));
    }

    @Test
    public void validatePin_withWrongPin_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            dairy.validatePin("wrongPin");
        });
    }

    @Test
    public void validatePin_withEmptyPin_shouldThrowException() {
        assertThrows(RuntimeException.class, () -> {
            dairy.validatePin("");
        });
    }


    @Test
    public void lockDairy_withCorrectPin_shouldLockDairy() {
        dairy.lockDairy(INITIAL_PIN);
        assertTrue(dairy.isLocked());
    }

    @Test
    public void lockDairy_withWrongPin_shouldThrowException() {
        assertThrows(RuntimeException.class, () -> {
            dairy.lockDairy("wrongPin");
        });
    }

    @Test
    public void unlockDairy_withCorrectPin_shouldUnlockDairy() {
        dairy.lockDairy(INITIAL_PIN);
        dairy.unlockDairy(INITIAL_PIN);
        assertFalse(dairy.isLocked());
    }

    @Test
    public void unlockDairy_withWrongPin_shouldThrowException() {
        dairy.lockDairy(INITIAL_PIN);
        assertThrows(RuntimeException.class, () -> {
            dairy.unlockDairy("wrongPin");
        });
    }


    @Test
    public void createDairyEntry_shouldIncrementEntriesCount() {
        DairyEntry entry1 = dairy.createDairyEntry("Title 1", "Body 1");
        DairyEntry entry2 = dairy.createDairyEntry("Title 2", "Body 2");

        assertEquals(1, entry1.getId());
        assertEquals(2, entry2.getId());
    }

    @Test
    public void createDairyEntry_whenDairyIsLocked_shouldThrowException() {
        dairy.lockDairy(INITIAL_PIN);
        assertThrows(RuntimeException.class, () -> {
            dairy.createDairyEntry("Title", "Body");
        });
    }

    @Test
    public void createDairyEntry_withEmptyTitle_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            dairy.createDairyEntry("", "Body");
        });
    }

    @Test
    public void createDairyEntry_withEmptyBody_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            dairy.createDairyEntry("Title", "");
        });
    }

    // Find Entry Tests
    @Test
    public void findDairyEntryById_existingEntry_shouldReturnEntry() {
        DairyEntry originalEntry = dairy.createDairyEntry("Title", "Body");
        DairyEntry foundEntry = dairy.findDairyEntryById(originalEntry.getId());

        assertEquals(originalEntry.getId(), foundEntry.getId());
        assertEquals(originalEntry.getTitle(), foundEntry.getTitle());
        assertEquals(originalEntry.getBody(), foundEntry.getBody());
    }


    @Test
    public void finddairyEntryById_whendairyIsLocked_shouldThrowException() {
        dairy.createDairyEntry("Title", "Body");
        dairy.lockDairy(INITIAL_PIN);

        assertThrows(IllegalStateException.class, () -> {
            dairy.findDairyEntryById(1);
        });
    }

    @Test
    public void updateEntryById_shouldUpdateTitleAndBody() {
        DairyEntry entry = dairy.createDairyEntry("Original Title", "Original Body");

        dairy.updateEntryById(entry.getId(), "New Title", "New Body");

        DairyEntry updatedEntry = dairy.findDairyEntryById(entry.getId());
        assertEquals("New Title", updatedEntry.getTitle());
        assertEquals("New Body", updatedEntry.getBody());
    }

    @Test
    public void updateEntryById_whenDairyIsLocked_shouldThrowException() {
        DairyEntry entry = dairy.createDairyEntry("Title", "Body");
        dairy.lockDairy(INITIAL_PIN);

        assertThrows(IllegalStateException.class, () -> {
            dairy.updateEntryById(entry.getId(), "New Title", "New Body");
        });
    }

    @Test
    public void updateEntryById_withNonExistingEntry_shouldThrowException() {
        assertThrows(RuntimeException.class, () -> {
            dairy.updateEntryById(999, "New Title", "New Body");
        });
    }




    @Test
    public void deleteEntryById_withNonExistingEntry_shouldThrowException() {
        assertThrows(RuntimeException.class, () -> {
            dairy.deleteDairyEntryById( INITIAL_PIN, 999);
        });
    }
}