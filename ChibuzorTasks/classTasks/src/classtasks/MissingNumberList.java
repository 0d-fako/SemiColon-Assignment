package classtasks;

import java.util.ArrayList;
import java.util.Arrays;

public class MissingNumberList{

    public ArrayList<Integer> missingNumberList(int[] numbersArray) {
        ArrayList<Integer> missingNumbers = new ArrayList<>();
        Arrays.sort(numbersArray);
        int smallest = numbersArray[0];
        int largest = numbersArray[numbersArray.length - 1];
        int currentIndex = 0;

        while (smallest <= largest) {
            if (currentIndex < numbersArray.length && numbersArray[currentIndex] == smallest) {
                currentIndex++;
            } else {
                missingNumbers.add(smallest);
            }
            smallest++;
        }

        return missingNumbers;
    }


}
