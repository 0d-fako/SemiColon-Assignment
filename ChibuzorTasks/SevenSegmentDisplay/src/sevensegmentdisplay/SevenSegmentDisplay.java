package sevensegmentdisplay;

public class SevenSegmentDisplay {
    public boolean validateInput(String binaryLetters) {
        if (binaryLetters.length() != 8) throw new IllegalArgumentException("Input must be 8 digits");
        for (char c : binaryLetters.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new IllegalArgumentException("Input must contain only binary characters ('0' or '1').");
            }
        }
        return true;
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

            for (int row = 0; row < 5; row++) {
                for (int column = 0; column < 4; column++) {
                    display[row][column] = ' ';
                }
            }

            if (convertArray[0] == 1) {
                for (int index = 0; index < 4; index++) {
                    display[0][index] = '#';
                }
            }
            if (convertArray[1] == 1) {
                for (int index = 0; index < 3; index++) {
                    display[index][3] = '#';
                }
            }
            if (convertArray[2] == 1) {
                for (int index = 2; index < 5; index++) {
                    display[index][3] = '#';
                }
            }
            if (convertArray[3] == 1) {
                for (int index = 0; index < 4; index++) {
                    display[4][index] = '#';
                }
            }
            if (convertArray[4] == 1) {
                for (int index = 2; index < 5; index++) {
                    display[index][0] = '#';
                }
            }
            if (convertArray[5] == 1) {
                for (int index = 0; index < 3; index++) {
                    display[index][0] = '#';
                }
            }
            if (convertArray[6] == 1) {
                for (int j = 0; j < 4; j++) {
                    display[2][j] = '#';
                }
            }

            return display;
        }

        public void display(char[][] display) {
            for (int row = 0; row < display.length; row++) {
                for (int column = 0; column < display[row].length; column++) {
                    System.out.print(display[row][column]);
                }
                System.out.println();

            }
        }

    }

