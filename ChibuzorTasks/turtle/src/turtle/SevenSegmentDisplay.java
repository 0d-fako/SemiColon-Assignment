package turtle;

public class SevenSegmentDisplay {

    public void validateInput(String binaryLetters) {
        if (binaryLetters.length() != 8) throw new IllegalArgumentException();
        for (char c : binaryLetters.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new IllegalArgumentException("Input must contain only binary characters ('0' or '1').");
            }
        }
    }


    public boolean isOn(String binaryLetters) {
        return binaryLetters.charAt(7) == '1';
    }

    public int[] convertStringToArrayOfIntegers(String binaryLetters) {
        int[] convertedArray = new int[binaryLetters.length()-1];
        for (int index = 0; index < binaryLetters.length()-1; index++) {
            convertedArray[index] = binaryLetters.charAt(index) == '1'? 1: 0;
        }
        return convertedArray;
    }
}
