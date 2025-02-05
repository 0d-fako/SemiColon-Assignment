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
        assertThrows(IllegalArgumentException.class, () -> {
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
        assertThrows(IllegalArgumentException.class, () -> {
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
        assertThrows(IllegalArgumentException.class, () -> {
            dairy.unlockDairy("wrongPin");
        });
    }


    @Test
    public void createdairyEntry_shouldIncrementEntriesCount() {
        DairyEntry entry1 = dairy.createDairyEntry("Title 1", "Body 1");
        DairyEntry entry2 = dairy.createDairyEntry("Title 2", "Body 2");

        assertEquals(1, entry1.getId());
        assertEquals(2, entry2.getId());
    }

    @Test
    public void createdairyEntry_whendairyIsLocked_shouldThrowException() {
        dairy.lockdairy(INITIAL_PIN);
        assertThrows(IllegalStateException.class, () -> {
            dairy.createdairyEntry("Title", "Body");
        });
    }

    @Test
    public void createdairyEntry_withEmptyTitle_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            dairy.createdairyEntry("", "Body");
        });
    }

    @Test
    public void createdairyEntry_withEmptyBody_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            dairy.createdairyEntry("Title", "");
        });
    }

    // Find Entry Tests
    @Test
    public void finddairyEntryById_existingEntry_shouldReturnEntry() {
        dairyEntry originalEntry = dairy.createdairyEntry("Title", "Body");
        dairyEntry foundEntry = dairy.findDairyEntryById(originalEntry.getId()).orElseThrow();

        assertEquals(originalEntry.getId(), foundEntry.getId());
        assertEquals(originalEntry.getTitle(), foundEntry.getTitle());
        assertEquals(originalEntry.getBody(), foundEntry.getBody());
    }

    @Test
    public void finddairyEntryById_nonExistingEntry_shouldReturnEmptyOptional() {
        assertTrue(dairy.finddairyEntryById(999).isEmpty());
    }

    @Test
    public void finddairyEntryById_whendairyIsLocked_shouldThrowException() {
        dairy.createdairyEntry("Title", "Body");
        dairy.lockdairy(INITIAL_PIN);

        assertThrows(IllegalStateException.class, () -> {
            dairy.finddairyEntryById(1);
        });
    }

    // Update Entry Tests
    @Test
    public void updateEntryById_shouldUpdateTitleAndBody() {
        dairyEntry entry = dairy.createdairyEntry("Original Title", "Original Body");

        dairy.updateEntryById(entry.getId(), "New Title", "New Body");

        dairyEntry updatedEntry = dairy.finddairyEntryById(entry.getId()).orElseThrow();
        assertEquals("New Title", updatedEntry.getTitle());
        assertEquals("New Body", updatedEntry.getBody());
    }

    @Test
    public void updateEntryById_whendairyIsLocked_shouldThrowException() {
        dairyEntry entry = dairy.createdairyEntry("Title", "Body");
        dairy.lockdairy(INITIAL_PIN);

        assertThrows(IllegalStateException.class, () -> {
            dairy.updateEntryById(entry.getId(), "New Title", "New Body");
        });
    }

    @Test
    public void updateEntryById_withNonExistingEntry_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            dairy.updateEntryById(999, "New Title", "New Body");
        });
    }

    // Delete Entry Tests
    @Test
    public void deleteEntryById_shouldRemoveEntry() {
        dairyEntry entry = dairy.createdairyEntry("Title", "Body");
        dairy.deleteEntryById(entry.getId());

        assertTrue(dairy.finddairyEntryById(entry.getId()).isEmpty());
    }

    @Test
    public void deleteEntryById_whendairyIsLocked_shouldThrowException() {
        dairyEntry entry = dairy.createdairyEntry("Title", "Body");
        dairy.lockdairy(INITIAL_PIN);

        assertThrows(IllegalStateException.class, () -> {
            dairy.deleteEntryById(entry.getId());
        });
    }

    @Test
    public void deleteEntryById_withNonExistingEntry_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            dairy.deleteEntryById(999);
        });
    }
}