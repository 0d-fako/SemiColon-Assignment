package turtle;

import java.util.Arrays;
public class ArrayKata{
    public int[][] modify (char [][] input) {
        int[][] output = new int[input.length][input[0].length];
        for (int row = 0; row < input.length; row++) {
            for (int column = 0; column < input[row].length; column++) {
                if (input[row][column] == 'x') {
                    output[row][column] = 1;
                } else {
                    output[row][column] = 0;
                }
            }

        }
        return output;
    }
}
