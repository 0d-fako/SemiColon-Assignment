package turtle;

public class SevenSegmentDisplay {

    public void validateInputLength(String binaryLetters) {
        if (binaryLetters.length() != 8) throw new IllegalArgumentException();
    }


    public boolean isOn(String binaryLetters) {
        return binaryLetters.charAt(7) == '1';
    }
}
