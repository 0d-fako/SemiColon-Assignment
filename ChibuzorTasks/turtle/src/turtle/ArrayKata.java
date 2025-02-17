package turtle;

import java.util.Arrays;
public class ArrayKata{
    public static void main(String... args){
        char[][] input = {{'x', 'o', 'x'}, {'x','x','o'}, {'x','o','o'}};
        int[][] output = new int[input.length][input[0].length];
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input[i].length; j++){
                if(input[i][j] == 'x'){
                    output[i][j] = 1;
                }else{
                    output[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < output.length; i++){
            for(int j = 0; j < output[i].length; j++){
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}
