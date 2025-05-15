package ArrayTasks;

import java.util.Arrays;

public class HighestCommonFactor {

    public static int highestCommonFactor(int[] numbers){
        int hcf = 0;
        int smallest = Arrays.stream(numbers).min().getAsInt();
        int largest = Arrays.stream(numbers).max().getAsInt();

        for(int i = smallest; i < largest; i++){
            if(numbers[i]%i == 0){
                hcf = i;
            }
        }
        return hcf;
    }

    public static void main (String ...args){

        System.out.println(highestCommonFactor(new int[]{5,25,50,80,100}));



    }
}
