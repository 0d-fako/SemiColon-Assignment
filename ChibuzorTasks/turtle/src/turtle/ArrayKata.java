package turtle;

import java.util.Arrays;
public class ArrayKata{
    public static void main(String... args){
        char[][] input = {{'x', 'o', 'x'}, {'x','x','o'}, {'x','o','o'}};
        int[][] output = new int[input.length][input[0].length];
        for(int row = 0; row < input.length; row++){
            for(int column = 0; column < input[i].length; column++){
                if(input[row][column] == 'x'){
                    output[row][column] = 1;
                }else{
                    output[row][column] = 0;
                }
            }
        }
        for(int row = 0; row < output.length; row++){
            for(int column = 0; column < output[row].length; column++){
                System.out.print(output[row][column] + " ");
            }
            System.out.println();
        }
    }
}
