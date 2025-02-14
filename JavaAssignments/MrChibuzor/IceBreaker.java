package MrChibuzor;

public class IceBreaker{
    public static void main(String... args){
        int[] input = {4,5,8,8,8,2,9};
        int[] output = new int[input.length];
        for(int i = 0; i < input.length; i++){
            if(input[i] % 2 == 0){
                output[i] = 0;
            }else{
                output[i] = 1;
            }
        }
        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + " ");
        }
    }
}