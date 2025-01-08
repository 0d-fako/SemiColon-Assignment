package TestDrivenDevelopment.arraySearch;
import java.util.Arrays;
import java.util.Scanner;


public class ArraySearch {

    public int array_search(int[] myList, int number){
        for(int index = 0; index < myList.length; index++){
            if (myList[index] == number){
                return index;
            }
        }
        return -1;
    }

public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArraySearch arraySearch = new ArraySearch();
        int[] myList = new int[10];
        System.out.println("Enter 10 numbers: ");
        for(int i = 0; i < myList.length; i++){
            myList[i] = input.nextInt();
        }

        System.out.println("Enter the number to be searched: ");
        int number = input.nextInt();

        System.out.print(Arrays.toString(myList));
        int result;
        result = arraySearch.array_search(myList, number);
        if(result == -1){
            System.out.println("\nElement not found");
        }else {
            System.out.printf("\nElement found at index %d\n", result);
        }
}


}
