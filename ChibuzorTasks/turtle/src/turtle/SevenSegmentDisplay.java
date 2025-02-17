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

    public char[][] createDisplayArray(int[] convertArray) {
        char[][] display = new char[5][4];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                display[i][j] = ' ';
            }
        }

        if (convertArray[0] == 1) {
            for (int j = 1; j < 3; j++) {
                display[0][j] = '#';
            }
        }
        if (convertArray[1] == 1) { // Upper-right segment (b)
            for (int i = 1; i < 3; i++) {
                display[i][3] = '#';
            }
        }
        if (convertArray[2] == 1) { // Lower-right segment (c)
            for (int i = 3; i < 5; i++) {
                display[i][3] = '#';
            }
        }
        if (convertArray[3] == 1) { // Bottom segment (d)
            for (int j = 1; j < 3; j++) {
                display[4][j] = '#';
            }
        }
        if (convertArray[4] == 1) { // Lower-left segment (e)
            for (int i = 3; i < 5; i++) {
                display[i][0] = '#';
            }
        }
        if (convertArray[5] == 1) { // Upper-left segment (f)
            for (int i = 1; i < 3; i++) {
                display[i][0] = '#';
            }
        }
        if (convertArray[6] == 1) { // Middle segment (g)
            for (int j = 1; j < 3; j++) {
                display[2][j] = '#';
            }
        }

        return display;
    }

}
