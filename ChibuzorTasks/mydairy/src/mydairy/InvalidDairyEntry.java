package mydairy;

public class InvalidDairyEntry extends RuntimeException {
    public InvalidDairyEntry(String message) {
        super("Invalid Dairy Entry");
    }
}
